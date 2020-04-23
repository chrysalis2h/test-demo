package com.example.testdemo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * @ClassName: LoginController
 *  * @Description: LoginController
 *  * @Author: HeJin
 *  * @Date: 2020\4\16 0016 15:36
 *  * @Version: v1.0 文件初始创建
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello jwt !";
    }

    @GetMapping("/admin")
    public String admin() {
        return "hello admin !";
    }
}
