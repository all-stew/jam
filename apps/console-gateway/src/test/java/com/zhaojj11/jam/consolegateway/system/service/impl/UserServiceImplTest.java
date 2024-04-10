package com.zhaojj11.jam.consolegateway.system.service.impl;

import com.zhaojj11.jam.consolegateway.domain.model.User;
import com.zhaojj11.jam.consolegateway.domain.repository.UserRepository;
import com.zhaojj11.jam.consolegateway.service.UserService;
import com.zhaojj11.jam.consolegateway.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Import({UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    /**
     * 单元测试时的数据暂存.
     */
    private static User userData;
    /**
     * userService.
     */
    @Resource
    private UserService userService;
    /**
     * 认证服务.
     */
    @MockBean
    private AuthenticationManager authenticationManager;
    /**
     * userRepository.
     */
    @MockBean
    private UserRepository userRepository;

    @BeforeAll
    static void init() {
        userData = new User();
        userData.setId(1L);
    }

    @Test
    void testFindByIdReturnNull() {
        Mockito.when(userRepository.findById(ArgumentMatchers.any(Long.class)))
            .thenReturn(Optional.empty());
        User user = userService.findById(1L);
        Assertions.assertNull(user);
    }

    @Test
    void testFindByIdReturnNotNull() {
        Mockito.when(userRepository.findById(ArgumentMatchers.any(Long.class)))
            .thenReturn(Optional.of(userData));
        User user = userService.findById(1L);
        Assertions.assertNotNull(user);
    }
}
