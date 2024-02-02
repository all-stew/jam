package com.zhaojj11.jam.consolegateway.system.entity.vo.request;

import lombok.Getter;
import lombok.ToString;

/**
 * @author zhaojj11
 */
@Getter
@ToString
public class LoginUserRequestVO {

    /**
     * username.
     */
    private String username;
    /**
     * password.
     */
    private String password;
}
