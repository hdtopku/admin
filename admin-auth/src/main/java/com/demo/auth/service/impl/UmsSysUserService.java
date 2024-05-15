package com.demo.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.auth.domain.entity.UmsSysUser;
import com.demo.auth.domain.vo.UmsSysUserInfoVo;
import com.demo.auth.domain.vo.UmsSysUserVo;
import com.demo.auth.mapper.UmsSysUserMapper;
import com.demo.auth.service.IUmsSysUserService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:24:29
 */
@Service
public class UmsSysUserService extends ServiceImpl<UmsSysUserMapper, UmsSysUser> implements IUmsSysUserService {
    @Override
    public UmsSysUserInfoVo getUserInfo() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext.getAuthentication() == null) {
            return null;
        }
        UmsSysUserVo umsSysUserVo = (UmsSysUserVo)securityContext.getAuthentication().getPrincipal();
        return BeanUtil.copyProperties(umsSysUserVo, UmsSysUserInfoVo.class);
    }
}
