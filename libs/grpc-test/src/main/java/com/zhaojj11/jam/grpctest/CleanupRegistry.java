package com.zhaojj11.jam.grpctest;

public interface CleanupRegistry<T> {

    /**
     * Register item to clean-up at end of test.
     *
     * @param cleanupItem item to cleanup
     * @param <R>         type of the item
     * @return the registered item
     */
    <R extends T> R register(R cleanupItem);

    /**
     * Stops all registered services and removes them from the registry.
     */
    void clear();
}
