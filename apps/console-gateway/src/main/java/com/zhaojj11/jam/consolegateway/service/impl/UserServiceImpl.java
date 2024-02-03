package com.zhaojj11.jam.consolegateway.service.impl;

import com.zhaojj11.jam.consolegateway.controller.entity.request.LoginUserRequestVO;
import com.zhaojj11.jam.consolegateway.domain.model.User;
import com.zhaojj11.jam.consolegateway.domain.repository.UserRepository;
import com.zhaojj11.jam.consolegateway.service.UserService;
import com.zhaojj11.jam.libs.jpa.service.impl.BaseServiceImpl;
import com.zhaojj11.jam.libs.springcore.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * user service 实现.
 *
 * @author zhaojunjie
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserServiceImpl
    extends BaseServiceImpl<UserRepository, User> implements UserService {

    private final AuthenticationManager authenticationManager;

    @Override
    public void login(final LoginUserRequestVO loginUserRequestVO) {
        UsernamePasswordAuthenticationToken token =
            new UsernamePasswordAuthenticationToken(
                loginUserRequestVO.getUsername(),
                loginUserRequestVO.getPassword()
            );
        try {
            authenticationManager.authenticate(token);
        } catch (AuthenticationException e) {
            throw Exceptions.unauthorized("用户不存在或者密码错误", e);
        }
    }
}
