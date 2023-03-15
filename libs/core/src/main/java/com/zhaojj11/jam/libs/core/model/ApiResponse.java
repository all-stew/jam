package com.zhaojj11.jam.libs.core.model;

import com.zhaojj11.jam.libs.core.constants.StringConstant;
import com.zhaojj11.jam.libs.core.enums.ApiResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一API返回
 *
 * @author zhaojj11
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private boolean success;
    private int code;
    private String msg;
    private T data;

    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<>(true, ApiResultCodeEnum.SUCCESS.getCode(), StringConstant.OK, null);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, ApiResultCodeEnum.SUCCESS.getCode(), StringConstant.OK, data);
    }

    public static <T> ApiResponse<T> fail(String msg) {
        return new ApiResponse<>(false, ApiResultCodeEnum.FAILED.getCode(), msg, null);
    }

    public static <T> ApiResponse<T> fail(int code, String msg) {
        return new ApiResponse<>(false, code, msg, null);
    }
}
