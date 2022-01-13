package com.qingyunshare.file.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiwenshare.common.result.RestResult;
import com.qingyunshare.file.domain.UserBean;

public interface IUserService extends IService<UserBean> {

    /**
     * 通过解析token获取user的phone，在通过phone查询用户数据
     *
     * @param token 用户token
     * @return UserBean
     */
    UserBean getUserBeanByToken(String token);

//    UserBean selectUserByopenid(String openid);

    /**
     * 用户注册
     *
     * @param userBean 用户信息
     * @return 结果
     */
    RestResult<String> registerUser(UserBean userBean);


    /**
     * 通过手机号获取用户信息
     *
     * @param telephone 手机号
     * @return UserBean
     */
    UserBean findUserInfoByTelephone(String telephone);






}
