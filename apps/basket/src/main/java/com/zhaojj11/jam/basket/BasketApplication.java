package com.zhaojj11.jam.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 *
 * @author zhaojj11
 */
@SpringBootApplication(scanBasePackages = "com.zhaojj11.jam.*")
public class BasketApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasketApplication.class, args);
    }
}
