package com.veio007.jtinyframe.util;


import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    public static void main(String[] args) {
        String json = "{\"content\":\"PAAS001200000001531\",\"msgTime\":1500605829828,\"msgType\":\"1\"}";
        JSONObject object = JSONObject.parseObject(json);
        System.out.println(object);
    }
}
