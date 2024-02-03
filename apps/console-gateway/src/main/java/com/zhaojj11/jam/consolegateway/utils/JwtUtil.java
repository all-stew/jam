package com.zhaojj11.jam.consolegateway.utils;

import com.zhaojj11.jam.libs.core.utils.UUIDUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author zhaojj11
 */
public final class JwtUtil {

    /**
     * jwt ttl 1小时.
     */
    public static final long DEFAULT_TTL = 60 * 60 * 1000L;

    private JwtUtil() {
    }

    /**
     * 生成默认的jwt.
     *
     * @param secret  密钥
     * @param subject token中需要存放的数据
     * @return jwt
     */
    public static String generateToken(
        final String secret, final String subject
    ) {
        return getJwtBuilder(secret, subject, DEFAULT_TTL, UUIDUtil.getUUID())
            .compact();
    }

    /**
     * 生成指定过期时间的jwt.
     *
     * @param secret    密钥
     * @param subject   token中需要存放的数据
     * @param ttlMillis token超时时间
     * @return jwt
     */
    public static String generateToken(
        final String secret, final String subject, final long ttlMillis
    ) {
        return getJwtBuilder(secret, subject, ttlMillis, UUIDUtil.getUUID())
            .compact();
    }

    /**
     * 生成指定uuid且指定过期时间的jwt.
     *
     * @param secret    密钥
     * @param uuid      uuid
     * @param subject   token中需要存放的数据
     * @param ttlMillis token超时时间
     * @return jwt
     */
    public static String generateToken(
        final String secret, final String uuid,
        final String subject, final long ttlMillis
    ) {
        return getJwtBuilder(secret, subject, ttlMillis, uuid)
            .compact();
    }

    private static JwtBuilder getJwtBuilder(
        final String secret, final String subject,
        final long ttlMillis, final String uuid
    ) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey(secret);
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
            // 唯一ID
            .setId(uuid)
            // 主题 可以是JSON数据
            .setSubject(subject)
            // 签发时间
            .setIssuedAt(now)
            // 加密
            .signWith(signatureAlgorithm, secretKey)
            // 过期时间
            .setExpiration(expDate);
    }

    /**
     * 生成加密后的密钥 secretKey.
     *
     * @param secret secret
     * @return 密钥
     */
    public static SecretKey generalKey(final String secret) {
        byte[] encodedKey = Base64.getDecoder().decode(secret);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解析jwt信息.
     *
     * @param secret secret
     * @param jwt    jwt字符串
     * @return Claims
     */
    public static Claims parseJwt(final String secret, final String jwt) {
        return Jwts.parser()
            .setSigningKey(generalKey(secret))
            .parseClaimsJws(jwt)
            .getBody();
    }
}

