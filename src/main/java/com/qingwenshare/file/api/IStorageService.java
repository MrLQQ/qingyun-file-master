package com.qingwenshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingwenshare.file.domain.StorageBean;

public interface IStorageService extends IService<StorageBean> {
    public Long getTotalStorageSize(Long userId);
    boolean checkStorage(Long userId, Long fileSize);
}
