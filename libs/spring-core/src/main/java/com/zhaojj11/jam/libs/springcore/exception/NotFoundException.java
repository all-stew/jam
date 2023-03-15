package com.zhaojj11.jam.libs.springcore.exception;

import com.zhaojj11.jam.libs.core.exception.BaseException;

/**
 * NotFoundException
 *
 * @author zhaojj11
 */
public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Exception e) {
        super(e);
    }

    public NotFoundException(Integer code, String message) {
        super(code, message);
    }
}
