package com.example.taobao.service;

import com.example.taobao.model.dto.UserAddDto;
import com.example.taobao.model.dto.UserUpdateDto;
import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.model.vo.UserVo;
import org.springframework.data.domain.Page;


public interface UserService {

    UserEntity addUser(UserAddDto userAddDto) throws Exception;

    void deleteUser(String email);

    UserEntity updateUser(UserUpdateDto userUpdateDto, String email);

    Page<UserVo> userPage(int pageNo, int size, String... sortBy);

    UserVo userInfo(String email);

}
