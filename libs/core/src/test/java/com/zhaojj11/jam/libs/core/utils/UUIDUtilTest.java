package com.zhaojj11.jam.libs.core.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UUIDUtilTest {
    @Test
    void getUuid() {
        String uuid = UUIDUtil.getUUID();
        assertEquals(32, uuid.length());
    }
}