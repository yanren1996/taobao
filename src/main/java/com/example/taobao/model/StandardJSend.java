package com.example.taobao.model;

import lombok.Builder;
import lombok.Getter;

/**
 * 用於 restful api 的標準響應
 */
@Builder
@Getter
public class StandardJSend<T> {

    private String status;
    private T data;
    private String message;

}
