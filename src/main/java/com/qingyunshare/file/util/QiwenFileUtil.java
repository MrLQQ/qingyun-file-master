package com.qingyunshare.file.util;

import com.qingyunshare.file.domain.UserFile;
import com.qiwenshare.common.util.DateUtil;

public class QiwenFileUtil {

    public static UserFile getQiwenDir(long userId, String filePath, String fileName) {
        UserFile userFile = new UserFile();
        userFile.setUserId(userId);
        userFile.setFileId(null);
        userFile.setFileName(fileName);
        userFile.setFilePath(filePath);
        userFile.setExtendName(null);
        userFile.setIsDir(1);
        userFile.setUploadTime(DateUtil.getCurrentTime());
        userFile.setDeleteFlag(0);
        userFile.setDeleteBatchNum(null);
        return userFile;
    }
}
