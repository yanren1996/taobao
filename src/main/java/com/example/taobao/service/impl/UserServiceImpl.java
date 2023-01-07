package com.example.taobao.service.impl;

import com.example.taobao.mapstruct.mapper.UserMapper;
import com.example.taobao.model.dto.UserAddDto;
import com.example.taobao.model.dto.UserUpdateDto;
import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.model.vo.UserVo;
import com.example.taobao.repository.UserRepository;
import com.example.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity addUser(UserAddDto userAddDto) throws Exception {
        UserEntity userEntity = userMapper.userAddDto2UserEntity(userAddDto);
        // user若存在，則發生例外
        if (userRepository.existsByEmail(userEntity.getEmail())) {
            throw new Exception("Email 已註冊");
        }

        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    @Override
    public UserEntity updateUser(UserUpdateDto userUpdateDto, String email) {
        UserEntity userEntity = userRepository.findByEmail(email, UserEntity.class);
        userMapper.userUpdateDto2UserEntity(userEntity, userUpdateDto);

        return userRepository.save(userEntity);
    }

    @Override
    public Page<UserVo> userPage(int pageNo, int size, String... sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);

        return userRepository.findByEmailNotNull(PageRequest.of(pageNo, size, sort), UserVo.class);
    }

    @Override
    public UserVo userInfo(String email) {
        return userRepository.findByEmail(email, UserVo.class);
    }

}
