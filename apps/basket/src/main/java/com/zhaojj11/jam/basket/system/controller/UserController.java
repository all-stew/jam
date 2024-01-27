package com.zhaojj11.jam.basket.system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @Value("${basket.user-jwt-token:test}")
//    private String userJwtToken;
//
//    private final UserService userService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<User>> getById(@PathVariable("id") Long id) {
//        User user = userService.findById(id);
//        if (user == null) {
//            throw new NotFoundException(ApiErrorConstants.MESSAGE_NOT_FOUND);
//        }
//        return ResponseEntity.ok(ApiResponse.ok(user));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse<Map<String, String>>> login(@RequestBody LoginUserRequestVO loginUserRequestVO) {
//        userService.login(loginUserRequestVO);
//        return success(Map.of("token", JwtUtil.generateToken(userJwtToken, loginUserRequestVO.getUsername())));
//    }
}
