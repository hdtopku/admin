package com.demo.auth.constants;

import lombok.Getter;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-12 21:55:00
 */
@Getter
public enum RedisCacheNames {
    LOGIN_TOKEN_KEY("login_token_key:");
    private final String value;


    RedisCacheNames(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
