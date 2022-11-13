package com.example.taobao.service.impl;

import com.example.taobao.entity.UserEntity;
import com.example.taobao.repository.UserRepository;
import com.example.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity addUser(UserEntity user) {
        // 判斷user是否已存在，不存在則可以新增使用者
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
