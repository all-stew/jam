package com.zhaojj11.jam.libs.core.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UUIDUtilTest {

    /**
     * expected length 32.
     */
    public static final int EXPECTED_LENGTH = 32;

    @Test
    void getUuid() {
        String uuid = UUIDUtil.getUUID();
        assertEquals(EXPECTED_LENGTH, uuid.length());
    }
}
