package com.zhaojj11.jam.basket.system.handler;

import com.zhaojj11.jam.basket.system.exception.UserLoginException;
import com.zhaojj11.jam.libs.core.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * basket的异常处理器
 *
 * @author zhaojj11
 */
@RestControllerAdvice
public class BasketExceptionHandler {
    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<ApiResponse<Object>> badRequestHandler(UserLoginException e) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
