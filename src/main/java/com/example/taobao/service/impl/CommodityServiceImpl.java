package com.example.taobao.service.impl;

import com.example.taobao.mapstruct.mapper.CommodityMapper;
import com.example.taobao.model.dto.CommodityAddDto;
import com.example.taobao.model.entity.CommodityEntity;
import com.example.taobao.repository.CommodityRepository;
import com.example.taobao.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public CommodityEntity add(CommodityAddDto commodityAddDto, String userEmail) {
        CommodityEntity commodityEntity = commodityMapper.commodityAddDto2CommodityEntity(commodityAddDto);
        commodityEntity.setSeller(userEmail);

        return commodityRepository.save(commodityEntity);
    }

    @Override
    public CommodityEntity find(UUID uuid) {
        return commodityRepository.findById(uuid).get();
    }

}
