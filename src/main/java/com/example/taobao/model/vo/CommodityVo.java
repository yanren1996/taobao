package com.example.taobao.model.vo;

import java.math.BigDecimal;
import java.util.UUID;

public interface CommodityVo {

    UUID getId();

    String getSeller();

    String getName();

    BigDecimal getPrice();

}
