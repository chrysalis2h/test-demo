package com.example.testdemo.web.controller;

import com.example.testdemo.base.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * @ClassName: LoginController
 *  * @Description: LoginController
 *  * @Author: HeJin
 *  * @Date: 2020\4\16 0016 15:36
 *  * @Version: v1.0 文件初始创建
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public CommonResult login() {
//        return "尚未登录，请登录";
        return new CommonResult<>().ok("尚未登录，请登录");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
//        return new CommonResult<>().ok("hello");
    }
}
