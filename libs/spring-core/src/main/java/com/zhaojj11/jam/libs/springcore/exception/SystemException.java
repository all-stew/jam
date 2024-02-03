package com.zhaojj11.jam.libs.springcore.exception;

import java.io.Serial;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

/**
 * 系统异常.
 *
 * @author zhaojj11
 */
public class SystemException extends BaseException {

    @Serial
    private static final long serialVersionUID = 3692679085864306201L;


    protected SystemException(final ProblemDetail pd, final Throwable cause) {
        super(HttpStatusCode.valueOf(pd.getStatus()), cause);
    }
}
