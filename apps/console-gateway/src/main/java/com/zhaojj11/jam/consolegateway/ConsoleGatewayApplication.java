package com.zhaojj11.jam.consolegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 *
 * @author zhaojj11
 */
@SpringBootApplication(scanBasePackages = "com.zhaojj11.jam.*")
public class ConsoleGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsoleGatewayApplication.class, args);
    }
}
