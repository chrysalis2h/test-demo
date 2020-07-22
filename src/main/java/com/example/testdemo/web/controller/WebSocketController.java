package com.example.testdemo.web.controller;

import com.example.testdemo.utils.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * @ClassName: WebSocketController
 *  * @Description: WebSocketController
 *  * @Author: HeJin
 *  * @Date: 2019\11\28 0028 9:53
 *  * @Version: v1.0 文件初始创建
 */
@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @GetMapping("/push")
    public Boolean connectWebScoket(String sid, String message) {
        boolean result = false;
        try {
            result = WebSocketServer.sendInfo(message, sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
