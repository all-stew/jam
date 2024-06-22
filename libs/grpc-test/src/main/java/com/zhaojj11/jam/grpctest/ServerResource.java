package com.zhaojj11.jam.grpctest;

import io.grpc.Server;
import java.util.concurrent.TimeUnit;

/**
 * server resources.
 */
public final class ServerResource extends Resource<Server> {

    ServerResource(final Server delegate) {
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
        final long timeout, final TimeUnit unit
    ) throws InterruptedException {
        return getDelegate().awaitTermination(timeout, unit);
    }
}
