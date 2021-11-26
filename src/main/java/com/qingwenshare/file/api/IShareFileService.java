package com.qingwenshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingwenshare.file.domain.ShareFile;
import com.qingwenshare.file.vo.share.ShareFileListVO;

import java.util.List;

public interface IShareFileService extends IService<ShareFile> {
    void batchInsertShareFile(List<ShareFile> shareFiles);
    List<ShareFileListVO> selectShareFileList(String shareBatchNum, String filePath);
}
