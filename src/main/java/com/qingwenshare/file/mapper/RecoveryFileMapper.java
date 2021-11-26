package com.qingwenshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingwenshare.file.vo.file.RecoveryFileListVo;
import com.qingwenshare.file.domain.RecoveryFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RecoveryFileMapper extends BaseMapper<RecoveryFile> {
    List<RecoveryFileListVo> selectRecoveryFileList(@Param("userId") Long userId);
}
