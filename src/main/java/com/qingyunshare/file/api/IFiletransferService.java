package com.qingyunshare.file.api;

import com.qingyunshare.file.domain.FileBean;
import com.qingyunshare.file.domain.StorageBean;
import com.qingyunshare.file.dto.file.DownloadFileDTO;
import com.qingyunshare.file.dto.file.PreviewDTO;
import com.qingyunshare.file.dto.file.UploadFileDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFiletransferService {





    /**
     * 上传文件
     * @param request 请求
     * @param UploadFileDto 文件信息
     */
    void uploadFile(HttpServletRequest request, UploadFileDTO UploadFileDto, Long userId);

    void downloadFile(HttpServletResponse httpServletResponse, DownloadFileDTO downloadFileDTO);
    void previewFile(HttpServletResponse httpServletResponse, PreviewDTO previewDTO);
    void deleteFile(FileBean fileBean);
    StorageBean selectStorageBean(StorageBean storageBean);

    void insertStorageBean(StorageBean storageBean);

    void updateStorageBean(StorageBean storageBean);

    StorageBean selectStorageByUser(StorageBean storageBean);

    /**
     * 通过userId查询用户已使用的存储空间
     * @param userId userId
     * @return 总文件大小
     */
    Long selectStorageSizeByUserId(Long userId);
}
