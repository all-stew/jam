package com.zhaojj11.jam.consolegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器.
 *
 * @author zhaojj11
 */
//CHECKSTYLE:OFF: checkstyle:HideUtilityClassConstructor
@SpringBootApplication(scanBasePackages = "com.zhaojj11.jam.*")
public class ConsoleGatewayApplication {

    /**
     * 启动器.
     *
     * @param args 启动参数
     */
    public static void main(final String[] args) {
        SpringApplication.run(ConsoleGatewayApplication.class, args);
    }
}
