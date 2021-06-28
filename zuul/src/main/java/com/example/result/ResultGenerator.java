package com.example.result;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result(ResultCode.SUCCESS.code(),DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result(ResultCode.SUCCESS.code(), data);
    }

    public static Result genFailResult(String message) {
        return new Result(ResultCode.FAIL.code(), message);
    }

    public static Result genFailUnauthorized(String message) {
        return new Result(ResultCode.UNAUTHORIZED.code(), message);
    }

}