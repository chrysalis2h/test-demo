package com.example.testdemo.base;

import lombok.Data;

/**
 *  * @ClassName: CommonResult
 *  * @Description: CommonResult
 *  * @Author: HeJin
 *  * @Date: 2019\12\17 0017 10:40
 *  * @Version: v1.0 文件初始创建
 */
@Data
public final class CommonResult<T> {
    private String code = "";
    private String msg = "";

    private T resultBody;

    public CommonResult() {
        code = "200";
    }

    public CommonResult ok(String msg){
        return ok(msg, null);
    }

    public CommonResult ok(String msg, T resultBody){
        this.msg = msg;
        this.resultBody = resultBody;
        return this;
    }

    public CommonResult error() {
        return error("500", "未知异常，请联系管理员");
    }

    public CommonResult error(String msg) {
        return error("500", msg);
    }

    public CommonResult error(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
}
