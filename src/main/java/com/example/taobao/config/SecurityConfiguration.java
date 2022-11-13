package com.example.taobao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 除了h2，所有請求都需要攔截
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/addUser").permitAll()
                .anyRequest().authenticated()
                .and()
                // 使用預設登入表單
                .formLogin()
                .and()
                // 使用localhost時，允許使用iframe(我們才能使用h2-console)
                .headers().frameOptions().sameOrigin()
                .and()
                // 關閉csrf(測試時關閉)
                .csrf().disable();
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
