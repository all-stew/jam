package com.zhaojj11.jam.libs.core.utils;

import java.util.UUID;

/**
 * uuid 工具
 *
 * @author zhaojj11
 */
public final class UUIDUtil {

    private UUIDUtil() {
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
