package com.example.taobao.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CommodityAddDto {

    private String name;
    private BigDecimal price;

}
