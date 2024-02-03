package com.zhaojj11.jam.consolegateway.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * open api config.
 *
 * @author zhaojj11
 */
@Configuration
public class OpenApiConfig {

    /**
     * api config.
     *
     * @return {@link OpenAPI}
     */
    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info(new Info()
            .title("Console Gateway API")
            .description("后台Api接口")
            .version("1.0.0"));
    }
}
