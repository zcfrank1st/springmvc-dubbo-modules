package com.deji.service;

import com.deji.api.HelloApi;

/**
 * Created by zcfrank1st on 12/4/15.
 */
public class HelloService implements HelloApi {
    public String hello() {
        return "hello world";
    }
}
