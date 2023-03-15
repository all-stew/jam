package com.zhaojj11.jam.libs.springcore.controller;

import com.zhaojj11.jam.libs.core.model.ApiResponse;
import com.zhaojj11.jam.libs.core.model.OkMessage;
import org.springframework.http.ResponseEntity;

/**
 * base controller
 *
 * @author zhaojj11
 */
public interface BaseController {

    /**
     * business ok
     *
     * @return ResponseEntity
     */
    default ResponseEntity<ApiResponse<OkMessage>> success() {
        return ResponseEntity.ok(ApiResponse.ok(OkMessage.ok()));
    }

    /**
     * business ok
     *
     * @param message 提示信息
     * @return ResponseEntity
     */
    default ResponseEntity<ApiResponse<OkMessage>> success(String message) {
        return ResponseEntity.ok(ApiResponse.ok(OkMessage.ok(message)));
    }


    /**
     * business ok with data
     *
     * @param <T>  type
     * @param data data
     * @return ResponseEntity with data
     */
    default <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(ApiResponse.ok(data));
    }
}
