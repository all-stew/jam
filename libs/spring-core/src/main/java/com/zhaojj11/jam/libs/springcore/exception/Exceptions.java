package com.zhaojj11.jam.libs.springcore.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * 异常方法使用.
 *
 * @author zhaojj11
 */
public final class Exceptions {

    private Exceptions() {
    }

    /**
     * 400 error.
     *
     * @param message error message
     * @param cause   case
     * @return SystemException
     */
    public static SystemException badRequest(
        final String message, final Throwable cause
    ) {
        return from(HttpStatus.BAD_REQUEST, message, cause);
    }

    /**
     * 401.
     *
     * @param message error message
     * @param cause   case
     * @return SystemException
     */
    public static SystemException unauthorized(
        final String message, final Throwable cause
    ) {
        return from(HttpStatus.UNAUTHORIZED, message, cause);
    }

    /**
     * 403.
     *
     * @param message error message
     * @param cause   case
     * @return SystemException
     */
    public static SystemException forbidden(
        final String message, final Throwable cause
    ) {
        return from(HttpStatus.FORBIDDEN, message, cause);
    }

    /**
     * 404.
     *
     * @param message error message
     * @param cause   case
     * @return SystemException
     */
    public static SystemException notFound(
        final String message, final Throwable cause
    ) {
        return from(HttpStatus.NOT_FOUND, message, cause);
    }

    /**
     * 500.
     *
     * @param message error message
     * @param cause   case
     * @return SystemException
     */
    public static SystemException internalServerError(
        final String message, final Throwable cause
    ) {
        return from(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }

    /**
     * from.
     *
     * @param httpStatus http status
     * @param message    error message
     * @param cause      case
     * @return SystemException
     */
    private static SystemException from(
        final HttpStatus httpStatus, final String message, final Throwable cause
    ) {
        ProblemDetail problemDetail =
            ProblemDetail.forStatusAndDetail(httpStatus, message);
        problemDetail.setTitle(httpStatus.getReasonPhrase());
        problemDetail.setProperty("timestamp", Instant.now());
        return new SystemException(problemDetail, cause);
    }
}
