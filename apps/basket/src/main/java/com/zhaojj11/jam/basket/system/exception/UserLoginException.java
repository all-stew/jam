package com.zhaojj11.jam.basket.system.exception;


import com.zhaojj11.jam.libs.springcore.exception.BaseException;
import java.io.Serial;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * 用户异常
 *
 * @author zhaojj11
 */
public class UserLoginException extends BaseException {
    @Serial
    private static final long serialVersionUID = -5922611015350258717L;

    public UserLoginException(String message) {
        super(HttpStatus.UNAUTHORIZED, asProblemDetail(message), null);
    }

    public UserLoginException(String message, Throwable throwable) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, asProblemDetail(message), throwable);
    }

    protected UserLoginException(HttpStatus httpStatus, ProblemDetail problemDetail, Throwable throwable) {
        super(httpStatus, problemDetail, throwable);
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, message);
        problemDetail.setTitle("Invalid Request");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
