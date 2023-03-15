package com.zhaojj11.jam.libs.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 成功信息
 *
 * @author zhaojj11
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OkMessage {
    private String message = "ok";

    public static OkMessage ok() {
        return new OkMessage();
    }

    public static OkMessage ok(String message) {
        return new OkMessage(message);
    }
}
