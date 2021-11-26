package com.qingwenshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.qingwenshare.file.domain.UserBean;

public interface UserMapper extends BaseMapper<UserBean> {
    int insertUser(UserBean userBean);

    int insertUserRole(long userId, long roleId);



}
