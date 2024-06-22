package com.zhaojj11.jam.grpctest;

import io.grpc.ManagedChannel;
import java.util.concurrent.TimeUnit;

/**
 * ManagedChannelResource.
 */
public final class ManagedChannelResource extends Resource<ManagedChannel> {

    ManagedChannelResource(final ManagedChannel delegate) {
        super(delegate);
    }

    @Override
    void shutdown() {
        getDelegate().shutdown();
    }

    @Override
    void shutdownNow() {
        getDelegate().shutdownNow();
    }

    @Override
    boolean awaitTermination(
        final long timeout,
        final TimeUnit unit
    ) throws InterruptedException {
        return getDelegate().awaitTermination(timeout, unit);
    }
}
