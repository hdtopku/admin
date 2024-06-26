package com.demo.auth.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by lxh at 2024-05-13 16:37:01
 */
@Data
public class UmsMenuVo {
    private Long id;
    private Long parentId;
    private String path;
    private String menuName;
    private String icon;
    private String componentPath;
    private Integer menuType;
    private Integer sort;
    private List<UmsMenuVo> children;
}
