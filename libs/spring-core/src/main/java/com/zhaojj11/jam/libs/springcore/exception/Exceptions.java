package com.zhaojj11.jam.libs.springcore.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * 异常方法使用
 *
 * @author zhaojj11
 */
public class Exceptions {

    private Exceptions() {
    }

    public static SystemException badRequest(String message, Throwable cause) {
        return from(HttpStatus.BAD_REQUEST, message, cause);
    }


    public static SystemException internalServerError(String message, Throwable cause) {
        return from(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }

    private static SystemException from(HttpStatus httpStatus, String message, Throwable cause) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, message);
        problemDetail.setTitle(httpStatus.getReasonPhrase());
        problemDetail.setProperty("timestamp", Instant.now());
        return new SystemException(problemDetail, cause);
    }
}
