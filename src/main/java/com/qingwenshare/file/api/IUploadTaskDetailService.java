package com.qingwenshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingwenshare.file.domain.UploadTaskDetail;

import java.util.List;

public interface IUploadTaskDetailService  extends IService<UploadTaskDetail> {
    List<Integer> getUploadedChunkNumList(String identifier);
}
