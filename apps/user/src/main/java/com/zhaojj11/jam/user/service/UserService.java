package com.zhaojj11.jam.user.service;

import com.zhaojj11.jam.user.domain.dto.UserDto;

/**
 * user service.
 *
 * @author zhaojj11
 */
public interface UserService {
    /**
     * 通过 username 获取 userDto.
     *
     * @param username username
     * @return userDto
     */
    UserDto getByUsername(String username);
}
