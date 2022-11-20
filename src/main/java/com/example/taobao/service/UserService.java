package com.example.taobao.service;

import com.example.taobao.entity.UserEntity;
import org.springframework.data.domain.Page;


public interface UserService {

    UserEntity addUser(UserEntity user) throws Exception;

    Page<UserEntity> userPage(int pageNo, int size, String... sortBy);

}
