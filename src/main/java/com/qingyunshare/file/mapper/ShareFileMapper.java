package com.qingyunshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingyunshare.file.vo.share.ShareFileListVO;
import com.qingyunshare.file.domain.ShareFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareFileMapper extends BaseMapper<ShareFile> {
    void batchInsertShareFile(List<ShareFile> shareFiles);
    List<ShareFileListVO> selectShareFileList(@Param("shareBatchNum") String shareBatchNum, @Param("shareFilePath") String filePath);
}
