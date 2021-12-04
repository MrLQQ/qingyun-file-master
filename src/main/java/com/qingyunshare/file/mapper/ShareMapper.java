package com.qingyunshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingyunshare.file.vo.share.ShareListVO;
import com.qingyunshare.file.domain.Share;

import java.util.List;

public interface ShareMapper  extends BaseMapper<Share> {

    List<ShareListVO> selectShareList(String shareFilePath, String shareBatchNum, Long beginCount, Long pageCount, Long userId);
    int selectShareListTotalCount(String shareFilePath,String shareBatchNum, Long userId);
}
