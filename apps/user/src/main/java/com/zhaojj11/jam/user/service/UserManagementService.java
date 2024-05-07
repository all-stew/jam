package com.zhaojj11.jam.user.service;

import com.zhaojj11.jam.user.domain.dto.UserDto;
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
     * @return user李彪
     */
    List<UserDto> list();

    /**
     * 新增用户.
     *
     * @param userDto 用户信息
     */
    void addUser(UserDto userDto);

    /**
     * 更新用户信息.
     *
     * @param userDto 用户信息
     */
    void updateUser(UserDto userDto);

    /**
     * 删除用户.
     *
     * @param userId 用户id
     */
    void removeUser(long userId);
}
