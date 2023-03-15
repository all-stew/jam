package com.zhaojj11.jam.sample.system.controller;

import com.zhaojj11.jam.libs.core.model.ApiErrorConstants;
import com.zhaojj11.jam.libs.core.model.ApiResponse;
import com.zhaojj11.jam.libs.springcore.controller.BaseController;
import com.zhaojj11.jam.libs.springcore.exception.NotFoundException;
import com.zhaojj11.jam.sample.system.entity.User;
import com.zhaojj11.jam.sample.system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojj11
 */
@Slf4j
@RestController
@RequestMapping("/api/user/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController implements BaseController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NotFoundException(ApiErrorConstants.MESSAGE_NOT_FOUND);
        }
        return ResponseEntity.ok(ApiResponse.ok(user));
    }
}
