package com.zhaojj11.jam.grpctest;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.AnnotationUtils;

/**
 * grpc test extension.
 */
public class GrpcTestExtension
    implements ParameterResolver, AfterEachCallback {

    /**
     * 默认的超时时间.
     */
    private static final long DEFAULT_TIMEOUT_SECONDS = 10L;

    @Override
    public final void afterEach(final ExtensionContext context) {
        getManagedChannelCleanupRegistry(context).clear();
        getServerCleanupRegistry(context).clear();
    }

    @Override
    public final boolean supportsParameter(
        final ParameterContext parameterContext,
        final ExtensionContext extensionContext
    ) {
        Class<?> type = parameterContext.getParameter().getType();
        return ServerCleanupRegistry.class.isAssignableFrom(type)
            || ManagedChannelCleanupRegistry.class.isAssignableFrom(type);
    }

    @Override
    public final Object resolveParameter(
        final ParameterContext parameterContext,
        final ExtensionContext extensionContext
    ) {
        Class<?> type = parameterContext.getParameter().getType();
        if (ServerCleanupRegistry.class.isAssignableFrom(type)) {
            return getServerCleanupRegistry(extensionContext);
        }
        if (ManagedChannelCleanupRegistry.class.isAssignableFrom(type)) {
            return getManagedChannelCleanupRegistry(extensionContext);
        }
        throw new ParameterResolutionException(
            "Failed to resolve parameter of type " + type + "."
        );
    }

    private Optional<CleanupTimeout> findCleanupTimeout(
        final ExtensionContext context
    ) {
        return AnnotationUtils.findAnnotation(
            context.getElement(), CleanupTimeout.class
        );
    }

    private ServerCleanupRegistry getServerCleanupRegistry(
        final ExtensionContext context
    ) {
        return getStore(context).getOrComputeIfAbsent(
            ServerCleanupRegistry.class,
            cls -> new ServerCleanupRegistry(
                findCleanupTimeout(context)
                    .map(CleanupTimeout::value)
                    .orElse(DEFAULT_TIMEOUT_SECONDS),
                findCleanupTimeout(context)
                    .map(CleanupTimeout::unit)
                    .orElse(TimeUnit.SECONDS)
            ),
            ServerCleanupRegistry.class
        );
    }

    private ManagedChannelCleanupRegistry getManagedChannelCleanupRegistry(
        final ExtensionContext context
    ) {
        return getStore(context).getOrComputeIfAbsent(
            ManagedChannelCleanupRegistry.class,
            cls -> new ManagedChannelCleanupRegistry(
                findCleanupTimeout(context)
                    .map(CleanupTimeout::value)
                    .orElse(DEFAULT_TIMEOUT_SECONDS),
                findCleanupTimeout(context)
                    .map(CleanupTimeout::unit)
                    .orElse(TimeUnit.SECONDS)
            ),
            ManagedChannelCleanupRegistry.class
        );
    }

    private ExtensionContext.Store getStore(final ExtensionContext context) {
        return context.getStore(
            ExtensionContext.Namespace.create(
                GrpcTestExtension.class, context.getRequiredTestMethod()
            )
        );
    }
}
