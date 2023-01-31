package com.zhaojj11.clockwork.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserExceptionTest {
    @Test
    void testUserException() {

        try {
            throw new UserException("hello");
        } catch (UserException e) {
            Assertions.assertEquals("hello", e.getMessage());
        }

        try {
            throw new UserException(200, "hello");
        } catch (UserException e) {
            Assertions.assertEquals("hello", e.getMessage());
            Assertions.assertEquals(200, e.getCode());
        }
    }
}