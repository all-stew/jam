package com.zhaojj11.jam.user.service;

import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import java.util.List;

/**
 * user management service.
 *
 * @author zhaojj11
 */
public interface UserManagementService {

    /**
     * 分页查询用户信息.
     *
     * @return user列表
     */
    List<LoginUserDto> list();

    /**
     * 新增用户.
     *
     * @param userDto 用户信息
     */
    void addUser(LoginUserDto userDto);

    /**
     * 更新用户信息.
     *
     * @param userDto 用户信息
     */
    void updateUser(LoginUserDto userDto);

    /**
     * 删除用户.
     *
     * @param userId 用户id
     */
    void removeUser(long userId);
}
