package com.qingwenshare.file.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingwenshare.file.api.IUploadTaskService;
import com.qingwenshare.file.domain.UploadTask;
import com.qingwenshare.file.mapper.UploadTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class UploadTaskService extends ServiceImpl<UploadTaskMapper, UploadTask> implements IUploadTaskService {


}
