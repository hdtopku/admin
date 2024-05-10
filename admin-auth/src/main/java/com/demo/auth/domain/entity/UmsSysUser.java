package com.demo.auth.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 11:49:18
 */
@Data
@TableName("ums_sys_user")
public class UmsSysUser implements java.io.Serializable {
    @TableId
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String mobile;
    private Integer gender;
    private String avatar;
    private String password;
    private String status;
    private String creator;
    private String updater;
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    private String remark;
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
}
