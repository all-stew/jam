package com.zhaojj11.jam.consolegateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author zhaojj11
 */
@Configuration
public class SecurityConfig {

    /**
     * security filter chain.
     *
     * @param httpSecurity httpSecurity
     * @return chain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(
        final HttpSecurity httpSecurity
    ) throws Exception {
        httpSecurity
            .csrf().disable()
            .authorizeHttpRequests(
                auth -> auth
                    .anyRequest().permitAll()
            ).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    /**
     * authenticationManager.
     * @param httpSecurity httpSecurity
     * @return authenticationManager
     * @throws Exception exception
     */
    @Bean
    public AuthenticationManager authenticationManager(
        final HttpSecurity httpSecurity
    ) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
            .build();
    }

    /**
     * 密码构造器.
     * @return encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
