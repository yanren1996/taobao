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
    public UserEntity addUser(UserEntity user) throws Exception {
        // user若存在，則發生例外
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new Exception("Email 已註冊");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
