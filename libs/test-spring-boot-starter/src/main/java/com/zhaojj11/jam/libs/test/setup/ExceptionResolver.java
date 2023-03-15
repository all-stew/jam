package com.zhaojj11.jam.libs.test.setup;

import com.zhaojj11.jam.libs.springcore.handler.GlobalExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;

/**
 * exception resolver
 *
 * @author zhaojj11
 */
public class ExceptionResolver {
    public static ExceptionHandlerExceptionResolver withExceptionControllerAdvice() {
        final ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            @Override
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(final HandlerMethod handlerMethod, @Nonnull final Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(GlobalExceptionHandler.class).resolveMethod(exception);
                if (method != null) {
                    return new ServletInvocableHandlerMethod(new GlobalExceptionHandler(), method);
                }
                return super.getExceptionHandlerMethod(handlerMethod, exception);
            }
        };
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }
}
