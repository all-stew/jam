package com.zhaojj11.jam.consolegateway.system.service.impl;

import com.zhaojj11.jam.consolegateway.system.domain.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author zhaojj11
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
            .findByUsername(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("invalid username or password")
            );
    }
}