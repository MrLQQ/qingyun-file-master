package com.qingyunshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingyunshare.file.domain.RecoveryFile;
import com.qingyunshare.file.domain.UserFile;
import com.qingyunshare.file.vo.file.RecoveryFileListVo;

import java.util.List;

public interface IRecoveryFileService extends IService<RecoveryFile> {
    void deleteRecoveryFile(UserFile userFile);
    void restorefile(String deleteBatchNum, String filePath, Long sessionUserId);
    List<RecoveryFileListVo> selectRecoveryFileList(Long userId);
}
