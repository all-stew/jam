package com.zhaojj11.jam.user.domain.transformer;

import com.zhaojj11.jam.protobuf.user.v1.LoginUser;
import com.zhaojj11.jam.protobuf.user.v1.UserInfo;
import com.zhaojj11.jam.protobuf.user.v1.UserStatus;
import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import com.zhaojj11.jam.user.domain.model.Role;
import com.zhaojj11.jam.user.domain.model.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

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

    /**
     * 从 user 到 proto.
     *
     * @param user user实体
     * @return user proto
     */
    static UserInfo toProto(final User user) {
        if (user == null) {
            return null;
        }
        return UserInfo.newBuilder()
            .setId(user.getId())
            .setUsername(user.getUsername())
            .setStatus(UserStatus.forNumber(user.getStatus().getValue()))
            .build();
    }

    /**
     * 从 user 到 proto.
     *
     * @param users user 实体列表
     * @return proto 列表
     */
    static List<UserInfo> toProto(final List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return new ArrayList<>();
        }
        return users.stream().map(UserTransformer::toProto).toList();
    }
}
