package com.example.taobao.service;

import com.example.taobao.model.dto.CommodityAddDto;
import com.example.taobao.model.entity.CommodityEntity;

import java.util.UUID;

public interface CommodityService {

    CommodityEntity add(CommodityAddDto commodityAddDto, String userEmail);

    CommodityEntity find(UUID uuid);

}
