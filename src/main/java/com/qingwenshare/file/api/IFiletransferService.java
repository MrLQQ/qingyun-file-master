package com.qingwenshare.file.api;

import com.qingwenshare.file.domain.FileBean;
import com.qingwenshare.file.domain.StorageBean;
import com.qingwenshare.file.dto.file.DownloadFileDTO;
import com.qingwenshare.file.dto.file.PreviewDTO;
import com.qingwenshare.file.dto.file.UploadFileDTO;

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
    Long selectStorageSizeByUserId(Long userId);
}
