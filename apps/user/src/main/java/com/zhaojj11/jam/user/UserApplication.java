package com.zhaojj11.jam.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 启动器.
 *
 * @author zhaojj11
 */
//CHECKSTYLE:OFF: checkstyle:HideUtilityClassConstructor
@SpringBootApplication
@EnableJpaAuditing
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
