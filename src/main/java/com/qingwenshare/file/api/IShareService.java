package com.qingwenshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingwenshare.file.domain.Share;
import com.qingwenshare.file.dto.sharefile.ShareListDTO;
import com.qingwenshare.file.vo.share.ShareListVO;

import java.util.List;

public interface IShareService  extends IService<Share> {
    List<ShareListVO> selectShareList(ShareListDTO shareListDTO, Long userId);
    int selectShareListTotalCount(ShareListDTO shareListDTO, Long userId);
}
