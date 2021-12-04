package com.qingyunshare.file.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingyunshare.file.api.IUploadTaskService;
import com.qingyunshare.file.domain.UploadTask;
import com.qingyunshare.file.mapper.UploadTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class UploadTaskService extends ServiceImpl<UploadTaskMapper, UploadTask> implements IUploadTaskService {


}
