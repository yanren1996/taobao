package com.example.taobao.mapstruct.mapper;

import com.example.taobao.model.dto.UserDto;
import com.example.taobao.model.entity.UserEntity;
import com.example.taobao.mapstruct.mapping.EncodedMapping;
import com.example.taobao.mapstruct.mapping.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", source = "password", qualifiedBy = EncodedMapping.class)
    UserEntity userDtoToUserEntity(UserDto userDto);

}
