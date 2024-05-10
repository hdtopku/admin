package com.demo.auth.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:02:10
 */
@Data
@TableName("ums_role")
public class UmsRole implements java.io.Serializable {
    @TableId("id")
    private Long roleId;
    private String roleLabel;
    private String roleName;
    private Integer sort;
    private String status;
    @TableLogic(value = "0", delval = "1")
    private String deleted;
    private String remark;
    private String creator;
    private String updater;
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
