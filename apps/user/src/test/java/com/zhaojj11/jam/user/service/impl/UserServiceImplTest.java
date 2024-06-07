package com.zhaojj11.jam.user.service.impl;

import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import com.zhaojj11.jam.user.domain.model.User;
import com.zhaojj11.jam.user.domain.model.User.Status;
import com.zhaojj11.jam.user.domain.repository.UserRepository;
import com.zhaojj11.jam.user.service.UserService;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Import({UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    /**
     * 测试用的暂存数据.
     */
    private static User userData;
    @MockBean
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @BeforeAll
    static void init() {
        userData = new User();
        userData.setId(1L);
        userData.setUsername("test");
        userData.setStatus(Status.ENABLED);
        userData.setCreatedTime(LocalDateTime.now());
    }

    @Test
    void testFindByIdReturnNull() {
        Mockito.when(
            userRepository.findByUsername(ArgumentMatchers.any(String.class))
        ).thenReturn(Optional.empty());
        LoginUserDto userDto = userService.getLoginUserByUsername("test");
        Assertions.assertNull(userDto);
    }

    @Test
    void testFindByIdReturnNotNull() {
        Mockito.when(
            userRepository.findByUsername(ArgumentMatchers.any(String.class))
        ).thenReturn(Optional.of(userData));
        LoginUserDto userDto = userService.getLoginUserByUsername("test");
        Assertions.assertNotNull(userDto);
    }


    @Test
    void testRegister() {
        Mockito.when(
            userRepository.save(ArgumentMatchers.any())
        ).thenReturn(userData);
        boolean register = userService.register("test", "test");
        Assertions.assertTrue(register);
    }
}
