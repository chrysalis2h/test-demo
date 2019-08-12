package com.example.testdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.testdemo.web.servlet")
public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);
    }

}
