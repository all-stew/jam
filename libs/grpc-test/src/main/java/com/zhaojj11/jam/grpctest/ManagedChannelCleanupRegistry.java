package com.zhaojj11.jam.grpctest;

import io.grpc.ManagedChannel;
import java.util.concurrent.TimeUnit;

/**
 * ManagedChannelCleanupRegistry.
 */
public final class ManagedChannelCleanupRegistry
    extends ResourceCleanupRegistry<ManagedChannel> {

    ManagedChannelCleanupRegistry(
        final long timeout,
        final TimeUnit timeoutUnit
    ) {
        super(timeout, timeoutUnit);
    }

    @Override
    protected Resource<ManagedChannel> wrap(final ManagedChannel service) {
        return new ManagedChannelResource(service);
    }
}
