package com.example.taobao.controller;

import com.example.taobao.entity.UserEntity;
import com.example.taobao.model.StandardJSend;
import com.example.taobao.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public StandardJSend addUser(@RequestBody String webJson){
        UserEntity user = getObjFromJson(webJson, UserEntity.class);
        UserEntity result = userService.addUser(user);
//        StandardJSend.builder()
//                .status("error")
//                .message("")
//                .build();
        return StandardJSend.builder()
                .data(result)
                .status("success")
                .build();
    }

    protected <T> T getObjFromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
}
