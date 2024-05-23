package com.zhaojj11.jam.user.domain.transformer;

import com.zhaojj11.jam.protobuf.user.v1.UserInfo;
import com.zhaojj11.jam.user.domain.dto.UserDto;
import com.zhaojj11.jam.user.domain.model.Role;
import com.zhaojj11.jam.user.domain.model.User;
import java.util.HashSet;
import java.util.List;

public interface UserTransformer {

    /**
     * 从 dto 转换到 proto.
     *
     * @param userDto userDto
     * @return UserInfo proto
     */
    static UserInfo toProto(final UserDto userDto) {
        return UserInfo.newBuilder()
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
    static UserDto fromPojo(final User user, final List<Role> roleList) {
        return UserDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .status(user.getStatus())
            .roles(new HashSet<>())
            .build();
    }
}
