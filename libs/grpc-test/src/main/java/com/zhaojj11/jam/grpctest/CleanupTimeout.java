package com.zhaojj11.jam.grpctest;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * Grace period for cleanup each single service.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CleanupTimeout {

    /**
     * Amount of time units.
     *
     * @return time units
     */
    long value();

    /**
     * Time unit for timeout.
     *
     * @return time unit
     */
    TimeUnit unit();
}
