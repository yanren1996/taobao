package com.example.taobao.controller;

import com.example.taobao.entity.UserEntity;
import com.example.taobao.model.StandardJSend;
import com.example.taobao.service.UserService;
import com.example.taobao.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello(){
        return "hello world!!";
    }

    @PostMapping("addUser")
    public StandardJSend addUser(@RequestBody String webJson) {
        UserEntity user = JsonUtil.getObjFromJson(webJson, UserEntity.class);

        try {
            UserEntity result = userService.addUser(user);
            return StandardJSend.builder()
                    .data(result)
                    .status("success")
                    .build();
        } catch (Exception e) {
            return StandardJSend.builder()
                    .status("error")
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("userPage/{pageNo}")
    public StandardJSend userPage(@PathVariable int pageNo) {
        Page<UserEntity> userEntityPage = userService.userPage(pageNo, 3, "email", "firstName");

        return StandardJSend.builder()
                .data(userEntityPage)
                .status("success")
                .build();
    }

}
