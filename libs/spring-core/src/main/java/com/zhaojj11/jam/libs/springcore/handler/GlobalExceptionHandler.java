package com.zhaojj11.jam.libs.springcore.handler;

import com.zhaojj11.jam.libs.core.model.ApiResponse;
import com.zhaojj11.jam.libs.springcore.exception.BadRequestException;
import com.zhaojj11.jam.libs.springcore.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author zhaojj11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> badRequestHandler(BadRequestException e) {
        return ResponseEntity.badRequest().body(ApiResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> badRequestHandler(NotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
