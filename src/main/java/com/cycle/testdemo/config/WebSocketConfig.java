package com.cycle.testdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *  * @ClassName: WebSocketConfig
 *  * @Description: websocket配置
 *  * @Author: HeJin
 *  * @Date: 2019\11\28 0028 9:39
 *  * @Version: v1.0 文件初始创建
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
