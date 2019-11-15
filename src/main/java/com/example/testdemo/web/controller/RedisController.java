package com.example.testdemo.web.controller;

import com.example.testdemo.utils.redis.RedisUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private Logger logger = LogManager.getLogger(RedisController.class);

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/get")
    public String get(String key){
        return redisUtils.get(key) == null ? "没有数据" : redisUtils.get(key).toString();
    }

    @GetMapping("/set")
    public String set(String key, String value){
        return String.valueOf(redisUtils.set(key, value));
    }
}
