package com.example.taobao.mapstruct.mapper;

import com.example.taobao.model.dto.CommodityAddDto;
import com.example.taobao.model.entity.CommodityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommodityMapper {

    CommodityEntity commodityAddDto2CommodityEntity(CommodityAddDto commodityAddDto);

}
