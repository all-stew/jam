package com.zhaojj11.jam.libs.core.exception;

import java.io.Serial;

/**
 * 基础异常
 *
 * @author zhaojj11
 */
public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1774497080485077592L;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
