package com.example.taobao.service.impl;

import com.example.taobao.entity.UserEntity;
import com.example.taobao.repository.UserRepository;
import com.example.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Email 已註冊");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Page<UserEntity> userPage(int pageNo, int size, String... sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);

        return userRepository.findAll(PageRequest.of(pageNo, size, sort));
    }

}
