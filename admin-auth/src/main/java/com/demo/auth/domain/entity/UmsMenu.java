package com.demo.auth.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:07:54
 */
@Data
@TableName("ums_menu")
public class UmsMenu implements java.io.Serializable {
    @TableId
    private Long id;
    private Long parentId;
    private String menuName;
    private String path;
    private String componentPath;
    private String perms;
    private String icon;
    private Integer menuType;
    private Integer sort;
    private Integer status;

    private String creator;
    private String updater;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    private String remark;
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
}
