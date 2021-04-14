package com.cycle.rubbish.config;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 *  * @ClassName: HandlerAutoConfiguration
 *  * @Description: HandlerAutoConfiguration
 *  * @Author: HeJin
 *  * @Date: 2019\12\18 0018 15:55
 *  * @Version: v1.0 文件初始创建
 */
//@Configuration
public class HandlerAutoConfiguration {

//    @Bean
    public SimpleMappingExceptionResolver exceptionHandler() {
        return new SimpleMappingExceptionResolver();
    }
}
