package com.zhaojj11.jam.grpctest;

/**
 * grpc 上下文清理异常.
 */
public class CleanupException extends RuntimeException {

    /**
     * 构造器.
     *
     * @param message 异常信息
     */
    public CleanupException(final String message) {
        super(message);
    }
}
