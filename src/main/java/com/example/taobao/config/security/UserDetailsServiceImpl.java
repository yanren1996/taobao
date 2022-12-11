package com.example.taobao.config.security;

import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username, UserEntity.class);
        if (user == null) {
            throw new UsernameNotFoundException("user not found:" + username);
        }

        return new UserDetailsImpl(user);
    }

}
