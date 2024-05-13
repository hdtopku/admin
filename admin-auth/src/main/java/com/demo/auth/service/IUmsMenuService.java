package com.demo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.auth.domain.entity.UmsMenu;
import com.demo.auth.domain.vo.UmsMenuVo;

import java.util.List;

public interface IUmsMenuService extends IService<UmsMenu> {
    List<UmsMenuVo> getSelfMenu();
}
