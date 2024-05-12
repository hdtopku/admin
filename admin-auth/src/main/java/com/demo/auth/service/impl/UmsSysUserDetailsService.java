package com.demo.auth.service.impl;

import com.demo.auth.domain.entity.UmsMenu;
import com.demo.auth.domain.entity.UmsRole;
import com.demo.auth.domain.vo.UmsSysUserVo;
import com.demo.auth.mapper.UmsMenuMapper;
import com.demo.auth.mapper.UmsSysUserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-11 22:47:52
 */
@Service
public class UmsSysUserDetailsService implements UserDetailsService {
    @Resource
    private UmsSysUserMapper sysUserMapper;
    @Resource
    private UmsMenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsSysUserVo user = sysUserMapper.selectByUsername(username);
        Set<Long> roleIds = user.getRoleList().stream().map(UmsRole::getRoleId).collect(Collectors.toSet());
        List<UmsMenu> umsMenus = menuMapper.selectByRoleIds(roleIds);
        user.setPerms(umsMenus.stream().map(UmsMenu::getPerms).collect(Collectors.toSet()));
        return user;
    }
}
