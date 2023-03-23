package com.zhaojj11.jam.libs.springcore.exception;

import com.zhaojj11.jam.libs.core.exception.BaseException;

import java.io.Serial;

/**
 * BadRequestException
 *
 * @author zhaojj11
 */
public class BadRequestException extends BaseException {
    @Serial
    private static final long serialVersionUID = -4470927182478751331L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
