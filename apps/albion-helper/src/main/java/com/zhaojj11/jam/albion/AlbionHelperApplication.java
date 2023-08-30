package com.zhaojj11.jam.albion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动器
 *
 * @author zhaojj11
 */
@EnableFeignClients(basePackages = {"com.zhaojj11.jam.albion"})
@EnableScheduling
@SpringBootApplication
public class AlbionHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbionHelperApplication.class, args);
    }

}
