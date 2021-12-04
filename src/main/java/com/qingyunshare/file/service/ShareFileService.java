package com.qingyunshare.file.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingyunshare.file.vo.share.ShareFileListVO;
import com.qingyunshare.file.api.IShareFileService;
import com.qingyunshare.file.domain.ShareFile;
import com.qingyunshare.file.mapper.ShareFileMapper;
import com.qingyunshare.file.mapper.UserFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class ShareFileService extends ServiceImpl<ShareFileMapper, ShareFile> implements IShareFileService {
    @Resource
    ShareFileMapper shareFileMapper;
    @Resource
    UserFileMapper userFileMapper;
    @Override
    public void batchInsertShareFile(List<ShareFile> shareFiles) {
        shareFileMapper.batchInsertShareFile(shareFiles);
    }

    @Override
    public List<ShareFileListVO> selectShareFileList(String shareBatchNum, String filePath) {
        return shareFileMapper.selectShareFileList(shareBatchNum, filePath);
    }

}
