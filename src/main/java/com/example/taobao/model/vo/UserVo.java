package com.example.taobao.model.vo;

import org.springframework.beans.factory.annotation.Value;

/**
 * 用於前端顯示User資料
 */
public interface UserVo {

    String getEmail();

    @Value("#{target.firstName + target.lastName}")
    String getFullName();

}
