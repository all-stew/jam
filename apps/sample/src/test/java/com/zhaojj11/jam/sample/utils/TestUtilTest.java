package com.zhaojj11.jam.sample.utils;

import com.zhaojj11.jam.sample.common.utils.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestUtilTest {
    @Test
    void test() {
        long number = 100;
        Assertions.assertEquals(String.valueOf(number), TestUtil.convertLongToString(number));
    }
}