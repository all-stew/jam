package com.zhaojj11.jam.libs.core.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * 类型转换工具.
 *
 * @author zhaojj11
 */
public final class TypeUtil {

    private TypeUtil() {
    }

    /**
     * java本地时间转换成UTC时间戳（秒）.
     *
     * @param localDateTime java本地时间
     * @return UTC时间戳（秒）
     */
    public static long toLong(final LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return 0;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        return localDateTime.atZone(zoneId).toEpochSecond();
    }

    /**
     * UTC时间转Java本地时间.
     *
     * @param epoch UTC timestamp
     * @return Java本地时间
     */
    public static LocalDateTime toLocalDateTime(final long epoch) {
        Instant instant = Instant.now();
        ZoneId systemZone = ZoneId.systemDefault();
        ZoneOffset currentOffsetForMyZone =
            systemZone.getRules().getOffset(instant);
        return LocalDateTime.ofEpochSecond(epoch, 0, currentOffsetForMyZone);
    }
}
