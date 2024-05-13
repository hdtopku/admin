package com.demo.common.response;

import java.io.Serial;
import java.util.HashMap;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:54:29
 */

public class Result<T> extends HashMap<String, Object> {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";
    public static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "success";
    private static final String FAIL_MSG = "failure";
    private static final int FAIL_CODE = 500;


    public Result() {
        put(CODE_TAG, SUCCESS_CODE);
        put(MSG_TAG, SUCCESS_MSG);
    }
    public Result(int code, String msg) {
        put(CODE_TAG, code);
        put(MSG_TAG, msg);
    }
    public Result(int code, String msg, T data) {
        put(CODE_TAG, code);
        put(MSG_TAG, msg);
        put(DATA_TAG, data);
    }
    public static <T> Result<T> success() {
        return new Result<>();
    }
    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }
    public static  <T> Result<T> success(String msg) {
        return new Result<>(SUCCESS_CODE, msg);
    }
    public static  <T> Result<T> success(String msg, T data) {
        return new Result<>(SUCCESS_CODE, msg, data);
    }
    public static  <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg);
    }
    public static  <T> Result<T> fail(String msg) {
        return new Result<>(FAIL_CODE, msg);
    }
    public static  <T> Result<T> fail(String msg, T data) {
        return new Result<>(FAIL_CODE, msg, data);
    }
    public static  <T> Result<T> fail() {
        return new Result<>(FAIL_CODE, FAIL_MSG);
    }
    @Override
    public  Result<T> put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
