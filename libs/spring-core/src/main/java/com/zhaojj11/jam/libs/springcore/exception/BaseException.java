package com.zhaojj11.jam.libs.springcore.exception;

import java.io.Serial;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

/**
 * 基础异常类
 * 系统中所有api异常都需要继承自该类.
 *
 * @author zhaojj11
 */
public abstract class BaseException extends ErrorResponseException {

    @Serial
    private static final long serialVersionUID = -6722367330999923297L;


    protected BaseException(final HttpStatusCode status) {
        super(status);
    }

    protected BaseException(
        final HttpStatusCode status, final Throwable cause
    ) {
        super(status, cause);
    }

    protected BaseException(
        final HttpStatusCode status, final ProblemDetail body,
        final Throwable cause
    ) {
        super(status, body, cause);
    }

    protected BaseException(
        final HttpStatusCode status, final ProblemDetail body,
        final Throwable cause, final String messageDetailCode,
        final Object[] messageDetailArguments
    ) {
        super(status, body, cause, messageDetailCode, messageDetailArguments);
    }
}
