package com.example.taobao.mapstruct.mapper;

import com.example.taobao.mapstruct.mapping.EncodedMapping;
import com.example.taobao.mapstruct.mapping.PasswordEncoderMapper;
import com.example.taobao.model.dto.UserAddDto;
import com.example.taobao.model.dto.UserUpdateDto;
import com.example.taobao.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "password", source = "password", qualifiedBy = EncodedMapping.class)
    UserEntity userAddDto2UserEntity(UserAddDto userAddDto);

    @Mapping(target = "password", source = "password", qualifiedBy = EncodedMapping.class)
    void userUpdateDto2UserEntity(@MappingTarget UserEntity userEntity, UserUpdateDto userUpdateDto);

}
