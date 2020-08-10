package com.cycle.testdemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 *  * @ClassName: DingDingUtils
 *  * @Description: DingDingUtils
 *  * @Author: HeJin
 *  * @Date: 2020\4\21 0021 14:38
 *  * @Version: v1.0 文件初始创建
 */
public class DingDingUtils {

    private static final String url = "https://oapi.dingtalk.com/robot/send?access_token=xxxx";
    private static final String secret = "xxxx";

    public static void main(String[] args) throws Exception {
        List<String> atList = Arrays.asList("手机号码");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", "今天加班");
        jsonObject.put("atList", atList);
        send(jsonObject, "text");
    }

    public static String getTimestampAndSign() throws Exception {
        Long timestamp = System.currentTimeMillis();

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        System.out.println(sign);
        return "timestamp=" + timestamp + "&sign=" + sign;
    }

    public static void send(JSONObject jsonObject, String type) throws Exception {
        String timestampAndSign = getTimestampAndSign();
        DingTalkClient client = new DefaultDingTalkClient(url + "&" + timestampAndSign);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        switch (type) {
            case "text":
                List<String> atList = jsonObject.get("atList") == null ? null : (List<String>) jsonObject.get("atList");
                request = sendText(jsonObject.getString("content"), atList);
                break;
            case "link":
                request = sendLink();
                break;
            case "md":
                request = sendMarkdown();
                break;
            default:
                break;
        }
        try {
            OapiRobotSendResponse response = client.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            request = sendText("程序发生异常了", null);
            OapiRobotSendResponse response = client.execute(request);
        }
    }

    private static OapiRobotSendRequest sendText(String content, List<String> atList) {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        if (atList != null && atList.size() > 0) {
            at.setAtMobiles(atList);
        } else {
            at.setIsAtAll("true");
        }
        request.setAt(at);
        return request;
    }

    private static OapiRobotSendRequest sendLink() {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl("https://www.dingtalk.com/");
        link.setPicUrl("");
        link.setTitle("时代的火车向前开");
        link.setText("这个即将发布的新版本，创始人xx称它为“红树林”。\n" +
                "而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林");
        request.setLink(link);
        return request;
    }

    private static OapiRobotSendRequest sendMarkdown() {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("杭州天气");
        markdown.setText("#### 杭州天气 @156xxxx8827\n" +
                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
                "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n" +
                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
        request.setMarkdown(markdown);
        return request;
    }
}
