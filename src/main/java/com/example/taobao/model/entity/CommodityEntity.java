package com.example.taobao.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 商品表
 */
@Getter
@Setter
@Entity
@Table(name = "commodity")
public class CommodityEntity {

    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    @Column(name = "seller", length = 320)
    private String seller;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "price", precision = 8, scale = 2)
    private BigDecimal price;

}
