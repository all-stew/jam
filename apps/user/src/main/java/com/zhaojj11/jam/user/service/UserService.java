package com.zhaojj11.jam.user.service;

import com.zhaojj11.jam.user.dto.UserDto;

/**
 * user service.
 *
 * @author zhaojj11
 */
public interface UserService {

    /**
     * 获取当前用户信息.
     *
     * @param id id
     * @return 用户信息
     */
    UserDto getInfo(long id);

    /**
     * 注册.
     *
     * @param userDto 用户信息
     */
    void register(UserDto userDto);

    /**
     * 更新用户信息.
     *
     * @param userDto 用户信息
     */
    void update(UserDto userDto);

    /**
     * 重置密码.
     *
     * @param userDto 用户信息
     */
    void resetPassword(UserDto userDto);
}
