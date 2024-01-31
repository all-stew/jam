package com.zhaojj11.jam.consolegateway.system.controller;

import com.zhaojj11.jam.consolegateway.system.domain.model.User;
import com.zhaojj11.jam.consolegateway.system.entity.vo.request.LoginUserRequestVO;
import com.zhaojj11.jam.consolegateway.system.service.UserService;
import com.zhaojj11.jam.consolegateway.system.utils.JwtUtil;
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
public class UserController {

    private final UserService userService;
    @Value("${user-jwt-token:test}")
    private String userJwtToken;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw Exceptions.notFound("not found", null);
        }
        return user;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginUserRequestVO loginUserRequestVO) {
        userService.login(loginUserRequestVO);
        return Map.of("token", JwtUtil.generateToken(userJwtToken, loginUserRequestVO.getUsername()));
    }
}
