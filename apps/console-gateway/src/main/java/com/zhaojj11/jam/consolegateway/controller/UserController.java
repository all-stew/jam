package com.zhaojj11.jam.consolegateway.controller;

import com.zhaojj11.jam.consolegateway.controller.entity.request.LoginUserRequestVO;
import com.zhaojj11.jam.consolegateway.domain.model.User;
import com.zhaojj11.jam.consolegateway.service.UserService;
import com.zhaojj11.jam.consolegateway.utils.JwtUtil;
import com.zhaojj11.jam.libs.springcore.exception.Exceptions;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojj11
 */
@Slf4j
@RestController
@RequestMapping("/api/user/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserController {

    private final UserService userService;
    @Value("${user-jwt-token:test}")
    private String userJwtToken;

    /**
     * 通过id获取User.
     *
     * @param id userid
     * @return User
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") final long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw Exceptions.notFound("not found", null);
        }
        return user;
    }

    /**
     * 登录方法.
     * @param request 登录body vo
     * @return token
     */
    @PostMapping("/login")
    public Map<String, String> login(
        @RequestBody final LoginUserRequestVO request
    ) {
        userService.login(request);
        return Map.of(
            "token", JwtUtil.generateToken(userJwtToken, request.getUsername())
        );
    }
}
