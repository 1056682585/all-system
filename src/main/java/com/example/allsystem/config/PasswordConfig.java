package com.example.allsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 密码加密
 */
@Configuration
@EnableWebSecurity
public class PasswordConfig {
    // 密码加密 Bean
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 关闭所有安全拦截，接口全部放行
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 所有请求不登录也能访问
                )
                .csrf(csrf -> csrf.disable()) // 关闭跨站防护
                .formLogin(form -> form.disable()) // 关闭默认登录页
                .httpBasic(httpBasic -> httpBasic.disable()); // 关闭基础认证

        return http.build();
    }

}
