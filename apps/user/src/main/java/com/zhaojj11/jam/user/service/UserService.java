package com.zhaojj11.jam.user.service;

import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import com.zhaojj11.jam.user.domain.model.User;

/**
 * user service.
 *
 * @author zhaojj11
 */
public interface UserService {

    /**
     * 通过 username 获取 loginUserDto 登录用户信息.
     *
     * @param username username
     * @return userDto
     */
    LoginUserDto getLoginUserByUsername(String username);

    /**
     * 通过 username 注册.
     *
     * @param username username
     * @param password password
     * @return 是否注册成功
     */
    User register(String username, String password);


    /**
     * 重置密码.
     *
     * @param userId      用户id
     * @param newPassword 新密码
     */
    void resetPassword(long userId, String newPassword);
}
