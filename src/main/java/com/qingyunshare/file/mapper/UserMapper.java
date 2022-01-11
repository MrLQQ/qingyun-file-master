package com.qingyunshare.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.qingyunshare.file.domain.UserBean;

public interface UserMapper extends BaseMapper<UserBean> {

    /**
     * 添加用户
     * @param userBean 用户信息
     * @return 成功返回1,否则返回0
     */
    int insertUser(UserBean userBean);

    /**
     * 添加用户角色
     * @param userId 用户id
     * @param roleId 角色id<br>
     *               1-管理员<br>
     *               2-普通用户
     * @return
     */
//    int insertUserRole(long userId, long roleId);



}
