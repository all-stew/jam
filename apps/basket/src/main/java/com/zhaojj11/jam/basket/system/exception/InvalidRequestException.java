package com.zhaojj11.jam.basket.system.exception;

import com.zhaojj11.jam.libs.springcore.exception.BaseException;
import java.io.Serial;
import java.net.URI;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * 请求异常
 *
 * @author zhaojj11
 */
public class InvalidRequestException extends BaseException {

    @Serial
    private static final long serialVersionUID = 1466664474145763776L;

    private static final String DEFAULT_ERROR_MESSAGE = "Invalid Request";


    protected InvalidRequestException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, asProblemDetail(message), null);
    }

    protected InvalidRequestException(String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, asProblemDetail(message), cause);
    }

    public static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, message);
        problemDetail.setTitle(DEFAULT_ERROR_MESSAGE);
        problemDetail.setType(URI.create("about:blank"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
