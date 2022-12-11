package com.example.taobao.controller;

import com.example.taobao.model.StandardJSend;
import com.example.taobao.model.dto.UserDto;
import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.model.vo.UserVo;
import com.example.taobao.service.UserService;
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
    public String hello() {
        return "hello world!!";
    }

    @PostMapping("addUser")
    public StandardJSend addUser(@RequestBody UserDto userDto) {
//        UserDto userDto = JsonUtil.getObjFromJson(webJson, UserDto.class);

        try {
            UserEntity userEntity = userService.addUser(userDto);
            return StandardJSend.builder()
                    .data(userEntity)
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
        Page<UserVo> userEntityPage = userService.userPage(pageNo, 3, "email", "firstName");

        return StandardJSend.builder()
                .data(userEntityPage)
                .status("success")
                .build();
    }

}
