package com.demo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.auth.domain.entity.UmsSysUser;
import com.demo.auth.mapper.UmsSysUserMapper;
import com.demo.auth.service.IUmsSysUserService;
import org.springframework.stereotype.Service;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:24:29
 */
@Service
public class UmsSysUserService extends ServiceImpl<UmsSysUserMapper, UmsSysUser> implements IUmsSysUserService {
}