package com.zhaojj11.jam.grpctest;

import java.util.concurrent.TimeUnit;

public abstract class Resource<T> {

    /**
     * resource.
     */
    private final T delegate;

    Resource(final T delegate) {
        this.delegate = delegate;
    }

    /**
     * 获取 resource.
     *
     * @return resource
     */
    T getDelegate() {
        return delegate;
    }

    abstract void shutdown();

    abstract void shutdownNow();

    abstract boolean awaitTermination(
        long timeout, TimeUnit unit
    ) throws InterruptedException;

    /**
     * toString.
     *
     * @return string
     */
    @Override
    public String toString() {
        return delegate.toString();
    }
}
