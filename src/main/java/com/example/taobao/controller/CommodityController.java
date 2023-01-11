package com.example.taobao.controller;

import com.example.taobao.model.StandardJSend;
import com.example.taobao.model.dto.CommodityAddDto;
import com.example.taobao.model.entity.CommodityEntity;
import com.example.taobao.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @PostMapping("add")
    public StandardJSend addCommodity(Authentication auth, @RequestBody CommodityAddDto dto) {
        CommodityEntity commodityEntity = commodityService.add(dto, auth.getName());

        return StandardJSend.builder()
                .data(commodityEntity)
                .status("success")
                .build();
    }

}
