package com.demo.auth.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.auth.domain.entity.UmsRole;
import com.demo.auth.domain.mapper.UmsRoleMapper;
import com.demo.auth.domain.service.IUmsRoleService;
import org.springframework.stereotype.Service;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:23:44
 */
@Service
public class UmsRoleService extends ServiceImpl<UmsRoleMapper, UmsRole> implements IUmsRoleService {
}
