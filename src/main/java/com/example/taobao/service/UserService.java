package com.example.taobao.service;

import com.example.taobao.model.dto.UserDto;
import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.model.vo.UserVo;
import org.springframework.data.domain.Page;


public interface UserService {

    UserEntity addUser(UserDto userDto) throws Exception;

    void deleteUser(String email);

    Page<UserVo> userPage(int pageNo, int size, String... sortBy);

    UserVo userInfo(String email);

}
