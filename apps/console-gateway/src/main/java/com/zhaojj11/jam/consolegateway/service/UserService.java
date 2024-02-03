package com.zhaojj11.jam.consolegateway.service;

import com.zhaojj11.jam.consolegateway.controller.entity.request.LoginUserRequestVO;
import com.zhaojj11.jam.consolegateway.domain.model.User;
import com.zhaojj11.jam.libs.jpa.service.BaseService;

/**
 * user service层.
 *
 * @author zhaojj11
 */
public interface UserService extends BaseService<User> {
    /**
     * 登录方法.
     *
     * @param loginUserRequestVO 登录对象
     */
    void login(LoginUserRequestVO loginUserRequestVO);
}
