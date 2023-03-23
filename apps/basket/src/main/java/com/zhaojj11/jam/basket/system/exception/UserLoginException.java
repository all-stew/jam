package com.zhaojj11.jam.basket.system.exception;

import com.zhaojj11.jam.libs.core.exception.BaseException;

import java.io.Serial;

/**
 * 用户异常
 *
 * @author zhaojj11
 */
public class UserLoginException extends BaseException {
    @Serial
    private static final long serialVersionUID = -5922611015350258717L;

    public UserLoginException(Throwable cause) {
        super(cause);
    }

    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
