package com.example.taobao.controller;

import com.example.taobao.model.StandardJSend;
import com.example.taobao.model.vo.UserVo;
import com.example.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("info")
    @ResponseBody
    public StandardJSend getUserName(Authentication auth) {
        UserVo userVo = userService.userInfo(auth.getName());

        return StandardJSend.builder()
                .data(userVo)
                .status("success")
                .build();
    }

    @GetMapping("delete")
    public StandardJSend deleteUser(Authentication auth) {
        userService.deleteUser(auth.getName());

        return StandardJSend.builder()
                .data("Done")
                .status("success")
                .build();
    }

}
