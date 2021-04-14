package com.cycle.rubbish.config;

import com.alibaba.fastjson.JSON;
import com.cycle.rubbish.base.CommonResult;
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

    @RestControllerAdvice("com.cycle.rubbish.web.controller")
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
            CommonResult commonResult = new CommonResult<>().ok("请求成功", body);
            System.out.println(body instanceof CommonResult);
            //处理返回值是String的情况
            if (body instanceof String) {
                return JSON.toJSONString(commonResult);
            }
            return commonResult;
        }
    }
}
