package com.cycle.rubbish.web.controller;

import com.cycle.rubbish.demo.temp.AnnotationTestComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AnotationTestController
 * @Description: AnotationTestController
 * @Author: HJ
 * @Date: 2021/4/14 21:47
 * @Version: v1.0 文件初始创建
 */
@RestController("annotation")
public class AnotationTestController {

    @Autowired
    private AnnotationTestComponent serverConfigComponent;

    // 1、测试@Value注解
    @Value("${server.port}")
    String testValue;
    // 2、通过@ConfigurationProperties读取为bean
    // 3、通过@ConfigurationProperties读取并校验
    // 3需要实现InitializingBean
    // 参见链接https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247486181&idx=2&sn=10db0ae64ef501f96a5b0dbc4bd78786&chksm=cea2452ef9d5cc384678e456427328600971180a77e40c13936b19369672ca3e342c26e92b50&token=816772476&lang=zh_CN#rd

    // 配置官方文档：https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config
    @GetMapping("/value")
    public String hello() {
        return testValue;
    }

    @GetMapping("/properties")
    public String admin() {
        return serverConfigComponent.getLocation();
    }
}
