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
    private int status = 1;
    private String errorCode = "";
    private String errorMsg = "";

    private T resultBody;

    public CommonResult() {
    }

    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }
    public CommonResult(int status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }
}
