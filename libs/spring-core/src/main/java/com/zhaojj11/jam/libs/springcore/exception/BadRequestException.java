package com.zhaojj11.jam.libs.springcore.exception;

import com.zhaojj11.jam.libs.core.exception.BaseException;

/**
 * BadRequestException
 *
 * @author zhaojj11
 */
public class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Exception e) {
        super(e);
    }

    public BadRequestException(Integer code, String message) {
        super(code, message);
    }
}
