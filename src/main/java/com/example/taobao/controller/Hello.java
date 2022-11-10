package com.example.taobao.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("getUserName")
    @ResponseBody
    public String getUserName(Authentication auth) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = auth.getName();
        System.out.println("登入的user:" + username);
        return username;
    }

}
