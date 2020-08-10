package com.cycle.testdemo.web.controller;

import com.cycle.testdemo.utils.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/get")
    public String get(String key) {
        return redisUtils.get(key) == null ? "没有数据" : redisUtils.get(key).toString();
    }

    @GetMapping("/set")
    public String set(String key, String value) {
        return String.valueOf(redisUtils.set(key, value));
    }
}
