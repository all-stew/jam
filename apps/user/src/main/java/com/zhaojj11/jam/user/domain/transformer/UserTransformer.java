package com.zhaojj11.jam.user.domain.transformer;

import com.zhaojj11.jam.protobuf.user.v1.LoginUser;
import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import com.zhaojj11.jam.user.domain.model.Role;
import com.zhaojj11.jam.user.domain.model.User;
import java.util.HashSet;
import java.util.List;

public interface UserTransformer {

    /**
     * 从 dto 转换到 proto.
     *
     * @param userDto userDto
     * @return LoginUser proto
     */
    static LoginUser toProto(final LoginUserDto userDto) {
        return LoginUser.newBuilder()
            .setUserId(userDto.getId())
            .setUsername(userDto.getUsername())
            .addAllRoles(userDto.getRoles())
            .build();
    }

    /**
     * 从 pojo 转换到 dto.
     *
     * @param user     user
     * @param roleList role
     * @return UserDto dto
     */
    static LoginUserDto fromPojo(final User user, final List<Role> roleList) {
        return LoginUserDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .status(user.getStatus())
            .roles(new HashSet<>())
            .build();
    }
}
