package com.example.taobao.repository;

import com.example.taobao.model.entity.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommodityRepository extends JpaRepository<CommodityEntity, UUID> {

}
