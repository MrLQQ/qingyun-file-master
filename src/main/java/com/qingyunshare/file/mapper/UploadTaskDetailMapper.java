package com.qingyunshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingyunshare.file.domain.UploadTaskDetail;

import java.util.List;

public interface UploadTaskDetailMapper extends BaseMapper<UploadTaskDetail> {
    List<Integer> selectUploadedChunkNumList(String identifier);
}
