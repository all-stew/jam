package com.zhaojj11.jam.consolegateway.service.impl;

import com.zhaojj11.jam.consolegateway.domain.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author zhaojj11
 */
@Service
public final class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
        final String username
    ) throws UsernameNotFoundException {
        return userRepository
            .findByUsername(username)
            .orElseThrow(
                () -> new UsernameNotFoundException(
                    "invalid username or password"
                )
            );
    }
}
