package com.demo.common.response;

import java.io.Serial;
import java.util.HashMap;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:54:29
 */

public class Result extends HashMap<String, Object> {
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
    public Result(int code, String msg, Object data) {
        put(CODE_TAG, code);
        put(MSG_TAG, msg);
        put(DATA_TAG, data);
    }
    public static Result success() {
        return new Result();
    }
    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, data);
    }
    public static Result success(String msg) {
        return new Result(SUCCESS_CODE, msg);
    }
    public static Result success(String msg, Object data) {
        return new Result(SUCCESS_CODE, msg, data);
    }
    public static Result fail(int code, String msg) {
        return new Result(code, msg);
    }
    public static Result fail(String msg) {
        return new Result(FAIL_CODE, msg);
    }
    public static Result fail(String msg, Object data) {
        return new Result(FAIL_CODE, msg, data);
    }
    public static Result fail() {
        return new Result(FAIL_CODE, FAIL_MSG);
    }
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
