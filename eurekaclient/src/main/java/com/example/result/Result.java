package com.example.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一API响应结果封装
 */
@ApiModel
public class Result<T> {
    @ApiModelProperty(value = "请求状态码")
    private int code;
    @ApiModelProperty(value = "状态码对应信息")
    private String message;
    @ApiModelProperty(value = "数据")
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.tips();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
