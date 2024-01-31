package com.zhaojj11.jam.consolegateway.system.service;

import com.zhaojj11.jam.consolegateway.system.domain.model.User;
import com.zhaojj11.jam.consolegateway.system.entity.vo.request.LoginUserRequestVO;
import com.zhaojj11.jam.libs.jpa.service.BaseService;

/**
 * user service层
 *
 * @author zhaojunjie
 */
public interface UserService extends BaseService<User> {
    /**
     * 登录方法
     *
     * @param loginUserRequestVO 登录对象
     */
    void login(LoginUserRequestVO loginUserRequestVO);
}
