package com.qingyunshare.file.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qingyunshare.file.api.IElasticSearchService;
import com.qingyunshare.file.component.FileDealComp;
import com.qingyunshare.file.service.FileService;
import com.qingyunshare.file.domain.FileBean;
import com.qingyunshare.file.domain.UserFile;
import com.qingyunshare.file.service.FiletransferService;
import com.qingyunshare.file.service.UserFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
public class TaskController {

    @Resource
    FileService fileService;
    @Resource
    UserFileService userFileService;
    @Resource
    FiletransferService filetransferService;
    @Autowired
    private IElasticSearchService elasticSearchService;
    @Resource
    FileDealComp fileDealComp;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void deleteFile() {

        LambdaQueryWrapper<FileBean> fileBeanLambdaQueryWrapper = new LambdaQueryWrapper<>();
        fileBeanLambdaQueryWrapper.eq(FileBean::getPointCount, 0);

        List<FileBean> fileBeanList = fileService.list(fileBeanLambdaQueryWrapper);
        for (int i = 0; i < fileBeanList.size(); i++) {
            FileBean fileBean = fileBeanList.get(i);
            log.info("删除本地文件：" + JSON.toJSONString(fileBean));
            filetransferService.deleteFile(fileBean);
            fileService.removeById(fileBean.getFileId());
        }

    }

    @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
    public void updateElasticSearch() {

        try {
            elasticSearchService.deleteAll();
        } catch (Exception e) {
            log.debug("删除ES失败:" + e);
        }

        List<UserFile> userfileList = userFileService.list();
        for (UserFile userFile : userfileList) {
            fileDealComp.uploadESByUserFileId(userFile.getUserFileId());
        }

    }
}
