package com.zhaojj11.jam.basket.system.exception;

import com.zhaojj11.jam.libs.springcore.exception.BaseException;
import java.io.Serial;
import java.net.URI;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * 用于系统基础异常包装
 *
 * @author zhaojj11
 */
public class BizException extends BaseException {

    @Serial
    private static final long serialVersionUID = 8753987890933071319L;

    public BizException(String message) {
        super(HttpStatus.BAD_REQUEST, asProblemDetail(message), null);
    }

    public BizException(String message, Throwable throwable) {
        super(HttpStatus.BAD_REQUEST, asProblemDetail(message), throwable);
    }

    protected BizException(HttpStatus httpStatus, ProblemDetail problemDetail, Throwable throwable) {
        super(httpStatus, problemDetail, throwable);
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message);
        problemDetail.setTitle("Invalid Request");
        problemDetail.setType(URI.create("about:blank"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
