package com.example.taobao.model;

import lombok.Builder;

/**
 * 用於 restful api 的標準響應
 */
@Builder
public class StandardJSend {

    private String status;

    private Object data;

    private String message;

}
