package com.zhaojj11.jam.user.service.impl;

import com.zhaojj11.jam.user.domain.dto.UserDto;
import com.zhaojj11.jam.user.domain.model.User;
import com.zhaojj11.jam.user.domain.repository.UserRepository;
import com.zhaojj11.jam.user.domain.transformer.UserTransformer;
import com.zhaojj11.jam.user.service.UserService;
import java.util.ArrayList;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public @Nullable UserDto getByUsername(@Nonnull final String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional
            .map(user -> UserTransformer.fromPojo(user, new ArrayList<>()))
            .orElse(null);
    }
}
