package com.qingyunshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingyunshare.file.domain.FileBean;

public interface IFileService  extends IService<FileBean> {

    void increaseFilePointCount(Long fileId);

    void decreaseFilePointCount(Long fileId);
    void unzipFile(long userFileId, int unzipMode, String filePath);





}
