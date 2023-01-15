package com.zhaojj11.jam.sample.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestUtilTest {
    @Test
    void test() {
        long number = 100;
        Assertions.assertEquals(String.valueOf(number), TestUtil.convertLongToString(number));
    }
}