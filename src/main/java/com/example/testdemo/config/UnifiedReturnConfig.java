package com.example.testdemo.config;

import com.example.testdemo.base.CommonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *  * @ClassName: UnifiedReturnConfig
 *  * @Description: UnifiedReturnConfig
 *  * @Author: HeJin
 *  * @Date: 2019\12\17 0017 10:42
 *  * @Version: v1.0 文件初始创建
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnConfig {

    @RestControllerAdvice("com.example.testdemo.web.controller")
    static class CommoneResultResponesAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (body instanceof CommonResult) {
                return body;
            }
            return new CommonResult<Object>().ok("请求成功", body);
        }
    }
}
