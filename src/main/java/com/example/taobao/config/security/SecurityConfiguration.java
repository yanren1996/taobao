package com.example.taobao.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 除了h2跟PublicController，所有請求都需要攔截
                // fixme 框架升級6.0後不曉得為啥 /h2-console/** 無法允許
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                // 使用預設登入表單
                .formLogin(Customizer.withDefaults())
                // 使用localhost時，允許使用iframe(我們才能使用h2-console)
                .headers(headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin))
                // 關閉csrf(測試時關閉)
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    public static void main(String[] args) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("1234"));
//    }

}
