package com.zhaojj11.jam.basket.system.utils;

import com.zhaojj11.jam.libs.core.utils.UUIDUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JwtUtilTest {
    /**
     * java.lang.IllegalArgumentException: Last unit does not have enough valid bits
     */
    private final static String secret = "test";

    @Test
    void testGenerateToken1() {
        String sub1 = "1234";
        String jwt1 = JwtUtil.generateToken(secret, sub1);
        Claims claims1 = JwtUtil.parseJwt(secret, jwt1);
        assertEquals(claims1.getSubject(), sub1);
    }

    @Test
    void testGenerateToken2() {
        String sub2 = "12345";
        String jwt2 = JwtUtil.generateToken(secret, sub2, 1000);
        Claims claims2 = JwtUtil.parseJwt(secret, jwt2);
        assertEquals(claims2.getSubject(), sub2);
    }

    @Test
    void testGenerateToken3() {
        String sub3 = "12345";
        String uuid = UUIDUtil.getUUID();
        String jwt3 = JwtUtil.generateToken(secret, uuid, sub3, 2000);
        Claims claims3 = JwtUtil.parseJwt(secret, jwt3);
        assertEquals(claims3.getSubject(), sub3);
    }

    @Test
    void generalKey() {
        SecretKey secretKey = JwtUtil.generalKey(secret);
        SecretKey secretKey2 = JwtUtil.generalKey(secret);
        assertEquals(secretKey.getFormat(), secretKey2.getFormat());
        assertArrayEquals(secretKey.getEncoded(), secretKey2.getEncoded());
        assertEquals(secretKey.getAlgorithm(), secretKey2.getAlgorithm());
    }
}