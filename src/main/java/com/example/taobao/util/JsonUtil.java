package com.example.taobao.util;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    public static <T> T getObjFromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

}
