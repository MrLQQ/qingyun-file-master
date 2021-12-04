package com.qingyunshare.file.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingyunshare.file.dto.sharefile.ShareListDTO;
import com.qingyunshare.file.vo.share.ShareListVO;
import com.qingyunshare.file.api.IShareService;
import com.qingyunshare.file.domain.Share;
import com.qingyunshare.file.mapper.ShareMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class ShareService extends ServiceImpl<ShareMapper, Share> implements IShareService {

    @Resource
    ShareMapper shareMapper;

    @Override
    public List<ShareListVO> selectShareList(ShareListDTO shareListDTO, Long userId) {
        Long beginCount = (shareListDTO.getCurrentPage() - 1) * shareListDTO.getPageCount();
        return shareMapper.selectShareList(shareListDTO.getShareFilePath(),
                shareListDTO.getShareBatchNum(),
                beginCount, shareListDTO.getPageCount(), userId);
    }

    @Override
    public int selectShareListTotalCount(ShareListDTO shareListDTO, Long userId) {
        return shareMapper.selectShareListTotalCount(shareListDTO.getShareFilePath(), shareListDTO.getShareBatchNum(), userId);
    }
}
