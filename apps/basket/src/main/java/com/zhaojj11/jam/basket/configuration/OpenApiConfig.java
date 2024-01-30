package com.zhaojj11.jam.basket.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * open api config
 *
 * @author zhaojj11
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info(new Info()
            .title("SpringDoc API Test")
            .description("SpringDoc Simple Application Test")
            .version("0.0.1"));
    }
}
