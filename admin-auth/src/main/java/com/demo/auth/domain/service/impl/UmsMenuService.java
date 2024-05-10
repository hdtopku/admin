package com.demo.auth.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.auth.domain.entity.UmsMenu;
import com.demo.auth.domain.mapper.UmsMenuMapper;
import com.demo.auth.domain.service.IUmsMenuService;
import org.springframework.stereotype.Service;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:22:38
 */
@Service
public class UmsMenuService extends ServiceImpl<UmsMenuMapper, UmsMenu> implements IUmsMenuService {
}
