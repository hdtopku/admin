package com.demo.auth.domain.dto;

import lombok.Data;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-11 20:21:31
 */
@Data
public class LoginParam implements java.io.Serializable {
    private String username;
    private String password;
    private String rememberMe;
}
