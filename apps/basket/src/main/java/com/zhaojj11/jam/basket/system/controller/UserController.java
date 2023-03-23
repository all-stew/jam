package com.zhaojj11.jam.basket.system.controller;

import com.zhaojj11.jam.basket.system.domain.model.User;
import com.zhaojj11.jam.basket.system.entity.vo.request.LoginUserRequestVO;
import com.zhaojj11.jam.basket.system.service.UserService;
import com.zhaojj11.jam.basket.system.utils.JwtUtil;
import com.zhaojj11.jam.libs.core.model.ApiErrorConstants;
import com.zhaojj11.jam.libs.core.model.ApiResponse;
import com.zhaojj11.jam.libs.springcore.controller.BaseController;
import com.zhaojj11.jam.libs.springcore.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhaojj11
 */
@Slf4j
@RestController
@RequestMapping("/api/user/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController implements BaseController {
    @Value("${basket.user-jwt-token:test}")
    private String userJwtToken;

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NotFoundException(ApiErrorConstants.MESSAGE_NOT_FOUND);
        }
        return ResponseEntity.ok(ApiResponse.ok(user));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Map<String, String>>> login(@RequestBody LoginUserRequestVO loginUserRequestVO) {
        userService.login(loginUserRequestVO);
        return success(Map.of("token", JwtUtil.generateToken(userJwtToken, loginUserRequestVO.getUsername())));
    }
}
