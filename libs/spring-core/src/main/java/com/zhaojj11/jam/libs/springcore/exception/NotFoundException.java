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

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
