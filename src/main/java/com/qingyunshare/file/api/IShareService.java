package com.qingyunshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingyunshare.file.domain.Share;
import com.qingyunshare.file.dto.sharefile.ShareListDTO;
import com.qingyunshare.file.vo.share.ShareListVO;

import java.util.List;

public interface IShareService  extends IService<Share> {
    List<ShareListVO> selectShareList(ShareListDTO shareListDTO, Long userId);
    int selectShareListTotalCount(ShareListDTO shareListDTO, Long userId);
}
