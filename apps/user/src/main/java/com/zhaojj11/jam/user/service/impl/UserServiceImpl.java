package com.zhaojj11.jam.user.service.impl;

import com.zhaojj11.jam.libs.core.utils.UUIDUtil;
import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import com.zhaojj11.jam.user.domain.model.User;
import com.zhaojj11.jam.user.domain.model.User.Status;
import com.zhaojj11.jam.user.domain.repository.UserRepository;
import com.zhaojj11.jam.user.domain.transformer.UserTransformer;
import com.zhaojj11.jam.user.service.UserService;
import java.util.ArrayList;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public @Nullable LoginUserDto getLoginUserByUsername(
        @Nonnull final String username
    ) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional
            .map(user -> UserTransformer.fromPojo(user, new ArrayList<>()))
            .orElse(null);
    }

    @Override
    public boolean register(
        @Nonnull final String username,
        @Nonnull final String password
    ) {
        // 1. 生成一个随机的salt
        String uuidSalt = UUIDUtil.getUUID();

        // 2. 生成混合密码和盐的字符
        String mixed = password + uuidSalt;

        // 3. 将混合后的字符串 MD5
        String passwordMd5 = DigestUtils.sha256Hex(mixed);

        // 4. 构建user 并且保存
        userRepository.save(User.builder()
            .username(username)
            .salt(uuidSalt)
            .password(passwordMd5)
            .status(Status.DISABLED)
            .build());

        return true;
    }
}
