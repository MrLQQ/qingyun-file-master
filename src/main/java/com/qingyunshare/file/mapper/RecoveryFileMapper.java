package com.qingyunshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingyunshare.file.vo.file.RecoveryFileListVo;
import com.qingyunshare.file.domain.RecoveryFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RecoveryFileMapper extends BaseMapper<RecoveryFile> {
    List<RecoveryFileListVo> selectRecoveryFileList(@Param("userId") Long userId);
}
