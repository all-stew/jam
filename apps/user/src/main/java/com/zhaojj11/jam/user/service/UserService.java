package com.zhaojj11.jam.user.service;

import com.zhaojj11.jam.user.domain.dto.LoginUserDto;

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
    boolean register(String username, String password);
}
