package com.example.result;


/**
 * 统一API响应结果封装
 */
//@ApiModel
public class Result<T> {
//    @ApiModelProperty(value = "请求状态码")
    private int code;
//    @ApiModelProperty(value = "状态码对应信息")
    private String message;
//    @ApiModelProperty(value = "数据")
    private T data;

//    public Result setCode(ResultCode resultCode) {
//        this.code = resultCode.code();
//        this.message = resultCode.tips();
//        return this;
//    }

    public Result(){

    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
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
