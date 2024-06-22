package com.zhaojj11.jam.grpctest;

import io.grpc.Server;
import java.util.concurrent.TimeUnit;

/**
 * ServerCleanupRegistry.
 */
public final class ServerCleanupRegistry
    extends ResourceCleanupRegistry<Server> {

    /**
     * 构造器.
     *
     * @param timeout     超时时间
     * @param timeoutUnit 时间单位
     */
    public ServerCleanupRegistry(
        final long timeout, final TimeUnit timeoutUnit
    ) {
        super(timeout, timeoutUnit);
    }

    @Override
    protected Resource<Server> wrap(final Server service) {
        return new ServerResource(service);
    }
}
