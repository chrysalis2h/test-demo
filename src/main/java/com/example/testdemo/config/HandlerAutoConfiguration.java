package com.example.testdemo.config;

import com.example.testdemo.config.exception.BusinessExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  * @ClassName: HandlerAutoConfiguration
 *  * @Description: HandlerAutoConfiguration
 *  * @Author: HeJin
 *  * @Date: 2019\12\18 0018 15:55
 *  * @Version: v1.0 文件初始创建
 *
 */
@Configuration
public class HandlerAutoConfiguration {

    @Bean
    public BusinessExceptionHandler exceptionHandler(){
        return new BusinessExceptionHandler();
    }
}
