package com.demo.auth.domain.vo;

import lombok.Data;

import java.io.Serial;

/**
 * Created by lxh at 2024-05-15 11:46:17
 */
@Data
public class UmsSysUserInfoVo implements     java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String avatar;
}
