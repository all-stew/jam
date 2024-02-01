package com.zhaojj11.jam.libs.springcore.exception;

import java.io.Serial;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

/**
 * 基础异常类
 * 系统中所有api异常都需要继承自该类
 *
 * @author zhaojj11
 */
public abstract class BaseException extends ErrorResponseException {

    @Serial
    private static final long serialVersionUID = -6722367330999923297L;


    protected BaseException(HttpStatusCode status) {
        super(status);
    }

    protected BaseException(HttpStatusCode status, Throwable cause) {
        super(status, cause);
    }

    protected BaseException(final HttpStatusCode status, final ProblemDetail body, final Throwable cause) {
        super(status, body, cause);
    }

    protected BaseException(HttpStatusCode status, ProblemDetail body, Throwable cause, String messageDetailCode,
        Object[] messageDetailArguments) {
        super(status, body, cause, messageDetailCode, messageDetailArguments);
    }
}
