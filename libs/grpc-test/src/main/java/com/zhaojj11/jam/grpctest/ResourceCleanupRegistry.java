package com.zhaojj11.jam.grpctest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * ResourceCleanupRegistry.
 *
 * @param <T> type
 */
public abstract class ResourceCleanupRegistry<T>
    implements CleanupRegistry<T> {

    /**
     * server list.
     */
    private final Deque<Resource<T>> servers = new LinkedList<>();

    /**
     * 超时时间.
     */
    private final long timeout;
    /**
     * 超时时间单位.
     */
    private final TimeUnit timeoutUnit;

    ResourceCleanupRegistry(
        final long timeout, final TimeUnit timeoutUnit
    ) {
        this.timeout     = timeout;
        this.timeoutUnit = timeoutUnit;
    }

    protected abstract Resource<T> wrap(T service);

    /**
     * Register item to clean-up at end of test.
     *
     * @param cleanupItem item to cleanup
     * @param <R>         type of the item
     * @return the registered item
     */
    @Override
    public <R extends T> R register(final R cleanupItem) {
        servers.push(wrap(cleanupItem));
        return cleanupItem;
    }

    /**
     * Stops all registered services and removes them from the registry.
     */
    @Override
    public synchronized void clear() {
        shutdownAll();
        Optional<Resource<T>> firstFailed = awaitTermination();
        servers.clear();
        if (firstFailed.isPresent()) {
            throw new CleanupException(
                String.format("Failed to shutdown %s within given timeout.",
                    firstFailed.get())
            );
        }
    }

    private void shutdownAll() {
        for (Resource<?> server : servers) {
            server.shutdown();
        }
    }

    private Optional<Resource<T>> awaitTermination() {
        Optional<Resource<T>> firstFailed = servers.parallelStream()
            .filter(s -> awaitTermination(s) != TerminationState.SUCCESS)
            .findFirst();

        if (firstFailed.isPresent()) {
            // If any failed, force shutdown.
            servers.parallelStream().forEach(Resource::shutdownNow);
        }
        return firstFailed;
    }

    private TerminationState awaitTermination(
        final Resource<?> server
    ) {
        try {
            if (server.awaitTermination(timeout, timeoutUnit)) {
                return TerminationState.SUCCESS;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return TerminationState.INTERRUPTED;
        }
        return TerminationState.FAILURE;
    }

}
