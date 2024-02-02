package com.zhaojj11.jam.consolegateway.system.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zhaojj11.jam.libs.core.utils.UUIDUtil;
import io.jsonwebtoken.Claims;
import javax.crypto.SecretKey;
import org.junit.jupiter.api.Test;

class JwtUtilTest {

    /**
     * test secret.
     */
    private static final String SECRET = "test";
    /**
     * ttl.
     */
    private static final long TTL = 1000;

    @Test
    void testGenerateToken1() {
        String sub1 = "1234";
        String jwt1 = JwtUtil.generateToken(SECRET, sub1);
        Claims claims1 = JwtUtil.parseJwt(SECRET, jwt1);
        assertEquals(claims1.getSubject(), sub1);
    }

    @Test
    void testGenerateToken2() {
        String sub2 = "12345";
        String jwt2 = JwtUtil.generateToken(SECRET, sub2, TTL);
        Claims claims2 = JwtUtil.parseJwt(SECRET, jwt2);
        assertEquals(claims2.getSubject(), sub2);
    }

    @Test
    void testGenerateToken3() {
        String sub3 = "12345";
        String uuid = UUIDUtil.getUUID();
        String jwt3 = JwtUtil.generateToken(SECRET, uuid, sub3, TTL);
        Claims claims3 = JwtUtil.parseJwt(SECRET, jwt3);
        assertEquals(claims3.getSubject(), sub3);
    }

    @Test
    void generalKey() {
        SecretKey secretKey = JwtUtil.generalKey(SECRET);
        SecretKey secretKey2 = JwtUtil.generalKey(SECRET);
        assertEquals(secretKey.getFormat(), secretKey2.getFormat());
        assertArrayEquals(secretKey.getEncoded(), secretKey2.getEncoded());
        assertEquals(secretKey.getAlgorithm(), secretKey2.getAlgorithm());
    }
}
