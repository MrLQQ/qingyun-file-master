package com.qingwenshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingwenshare.file.domain.RecoveryFile;
import com.qingwenshare.file.domain.UserFile;
import com.qingwenshare.file.vo.file.RecoveryFileListVo;

import java.util.List;

public interface IRecoveryFileService extends IService<RecoveryFile> {
    void deleteRecoveryFile(UserFile userFile);
    void restorefile(String deleteBatchNum, String filePath, Long sessionUserId);
    List<RecoveryFileListVo> selectRecoveryFileList(Long userId);
}
