package com.zhaojj11.jam.sample.system.service.impl;

import com.zhaojj11.jam.libs.springjpacore.service.impl.BaseServiceImpl;
import com.zhaojj11.jam.sample.system.entity.User;
import com.zhaojj11.jam.sample.system.repository.UserRepository;
import com.zhaojj11.jam.sample.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * user service 实现
 *
 * @author zhaojunjie
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserRepository, User> implements UserService {
}
