package com.example.taobao.controller;

import com.example.taobao.model.StandardJSend;
import com.example.taobao.model.dto.UserUpdateDto;
import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.model.vo.UserVo;
import com.example.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("user")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("info")
    public StandardJSend getUserName(Authentication auth) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserVo userVo = userService.userInfo(auth.getName());

        return StandardJSend.builder()
                .data(userVo)
                .status("success")
                .build();
    }

    @PostMapping("update")
    public StandardJSend updateUser(Authentication auth, @RequestBody UserUpdateDto dto) {
        UserEntity userEntity = userService.updateUser(dto, auth.getName());

        return StandardJSend.builder()
                .data(userEntity)
                .status("success")
                .build();
    }

    @GetMapping("delete")
    public ModelAndView deleteUser(Authentication auth) throws IOException {
        userService.deleteUser(auth.getName());

        return new ModelAndView("forward:/logout");// DB刪除完登出
    }

}
