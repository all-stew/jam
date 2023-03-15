package com.zhaojj11.jam.sample.system.controller;

import com.zhaojj11.jam.sample.system.entity.User;
import com.zhaojj11.jam.sample.system.service.impl.UserServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.zhaojj11.jam.libs.test.setup.ExceptionResolver.withExceptionControllerAdvice;


@ExtendWith(SpringExtension.class)
class UserControllerTest {

    public static User userData;
    @Mock
    private UserServiceImpl userServiceImpl;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;

    @BeforeAll
    static void init() {
        userData = new User();
        userData.setId(1L);
    }

    @BeforeEach
    public void setupMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(withExceptionControllerAdvice()).build();
    }

    @Test
    void getByIdReturnNotNull() throws Exception {
        Mockito.when(userServiceImpl.findById(ArgumentMatchers.eq(1L))).thenReturn(userData);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/user/v1/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code", Matchers.is(200)))
                .andExpect(MockMvcResultMatchers.jsonPath("success", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("msg", Matchers.is("OK")))
                .andExpect(MockMvcResultMatchers.jsonPath("data.id", Matchers.is(1)))
                .andReturn();
    }

    @Test
    void getByIdReturnNull() throws Exception {
        Mockito.when(userServiceImpl.findById(ArgumentMatchers.eq(1L))).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/user/v1/{id}", 1L)
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }
}