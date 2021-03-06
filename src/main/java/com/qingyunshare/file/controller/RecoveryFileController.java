package com.qingyunshare.file.controller;

import com.alibaba.fastjson.JSON;
import com.qingyunshare.file.domain.FileBean;
import com.qingyunshare.file.domain.UserBean;
import com.qingyunshare.file.dto.file.DeleteRecoveryFileDTO;
import com.qingyunshare.file.dto.recoveryfile.BatchDeleteRecoveryFileDTO;
import com.qingyunshare.file.dto.recoveryfile.RestoreFileDTO;
import com.qingyunshare.file.vo.file.RecoveryFileListVo;
import com.qingyunshare.file.api.*;

import com.qingyunshare.file.domain.RecoveryFile;
import com.qingyunshare.file.domain.UserFile;
import com.qiwenshare.common.anno.MyLog;
import com.qiwenshare.common.exception.NotLoginException;
import com.qiwenshare.common.result.RestResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Tag(name = "recoveryfile", description = "文件删除后会进入回收站，该接口主要是对回收站文件进行管理")
@RestController
@Slf4j
@RequestMapping("/recoveryfile")
public class RecoveryFileController {
    @Resource
    IRecoveryFileService recoveryFileService;
    @Resource
    IUserFileService userFileService;
    @Resource
    IUserService userService;
    @Resource
    IFileService fileService;
    @Resource
    IFiletransferService filetransferService;
    public static final String CURRENT_MODULE = "回收站文件接口";

    @Operation(summary = "删除回收文件", description = "删除回收文件", tags = {"recoveryfile"})
    @MyLog(operation = "删除回收文件", module = CURRENT_MODULE)
    @RequestMapping(value = "/deleterecoveryfile", method = RequestMethod.POST)
    @ResponseBody
    public RestResult<String> deleteRecoveryFile(@RequestBody DeleteRecoveryFileDTO deleteRecoveryFileDTO, @RequestHeader("token") String token) {
        UserBean sessionUserBean = userService.getUserBeanByToken(token);
        if (sessionUserBean == null) {
            throw new NotLoginException();
        }

        RecoveryFile recoveryFile = recoveryFileService.getById(deleteRecoveryFileDTO.getRecoveryFileId());
        UserFile userFile =userFileService.getById(recoveryFile.getUserFileId());

        recoveryFileService.deleteRecoveryFile(userFile);
        recoveryFileService.removeById(deleteRecoveryFileDTO.getRecoveryFileId());
        Long filePointCount = fileService.getFilePointCount(userFile.getFileId());
        if (filePointCount != null && filePointCount == 0) {
            FileBean fileBean = fileService.getById(userFile.getFileId());
            try {
                filetransferService.deleteFile(fileBean);
                fileService.removeById(fileBean.getFileId());
            } catch (Exception e) {
                log.error("删除本地文件失败：" + JSON.toJSONString(fileBean));
            }
        }

        return RestResult.success().data("删除成功");
    }

    @Operation(summary = "批量删除回收文件", description = "批量删除回收文件", tags = {"recoveryfile"})
    @RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
    @MyLog(operation = "批量删除回收文件", module = CURRENT_MODULE)
    @ResponseBody
    public RestResult<String> batchDeleteRecoveryFile(@RequestBody BatchDeleteRecoveryFileDTO batchDeleteRecoveryFileDTO, @RequestHeader("token") String token) {
        UserBean sessionUserBean = userService.getUserBeanByToken(token);
        if (sessionUserBean == null) {
            throw new NotLoginException();
        }
        List<RecoveryFile> recoveryFileList = JSON.parseArray(batchDeleteRecoveryFileDTO.getRecoveryFileIds(), RecoveryFile.class);
        for (RecoveryFile recoveryFile : recoveryFileList) {

            RecoveryFile recoveryFile1 = recoveryFileService.getById(recoveryFile.getRecoveryFileId());
            UserFile userFile =userFileService.getById(recoveryFile1.getUserFileId());

            recoveryFileService.deleteRecoveryFile(userFile);
            recoveryFileService.removeById(recoveryFile.getRecoveryFileId());

            Long filePointCount = fileService.getFilePointCount(userFile.getFileId());
            if (filePointCount != null && filePointCount == 0) {
                FileBean fileBean = fileService.getById(userFile.getFileId());
                try {
                    filetransferService.deleteFile(fileBean);
                    fileService.removeById(fileBean.getFileId());
                } catch (Exception e) {
                    log.error("删除本地文件失败：" + JSON.toJSONString(fileBean));
                }
            }
        }
        return RestResult.success().data("批量删除成功");
    }

    @Operation(summary = "回收文件列表", description = "回收文件列表", tags = {"recoveryfile"})
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public RestResult<List<RecoveryFileListVo>> getRecoveryFileList(@RequestHeader("token") String token) {
        UserBean sessionUserBean = userService.getUserBeanByToken(token);
        if (sessionUserBean == null) {
            throw new NotLoginException();
        }
        RestResult<List<RecoveryFileListVo>> restResult = new RestResult<List<RecoveryFileListVo>>();
        List<RecoveryFileListVo> recoveryFileList = recoveryFileService.selectRecoveryFileList(sessionUserBean.getUserId());
        restResult.setData(recoveryFileList);
        restResult.setSuccess(true);

        return restResult;
    }

    @Operation(summary = "还原文件", description = "还原文件", tags = {"recoveryfile"})
    @RequestMapping(value = "/restorefile", method = RequestMethod.POST)
    @MyLog(operation = "还原文件", module = CURRENT_MODULE)
    @ResponseBody
    public RestResult restoreFile(@RequestBody RestoreFileDTO restoreFileDto, @RequestHeader("token") String token) {
        UserBean sessionUserBean = userService.getUserBeanByToken(token);
        if (sessionUserBean == null) {
            throw new NotLoginException();
        }
        recoveryFileService.restorefile(restoreFileDto.getDeleteBatchNum(), restoreFileDto.getFilePath(), sessionUserBean.getUserId());
        return RestResult.success().message("还原成功！");
    }

}









