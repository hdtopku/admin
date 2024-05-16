package com.demo.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.auth.domain.entity.UmsMenu;
import com.demo.auth.domain.entity.UmsRole;
import com.demo.auth.domain.vo.UmsMenuVo;
import com.demo.auth.domain.vo.UmsSysUserVo;
import com.demo.auth.mapper.UmsMenuMapper;
import com.demo.auth.service.IUmsMenuService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:22:38
 */
@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements IUmsMenuService {
    @Resource
    private UmsMenuMapper umsMenuMapper;

    public List<UmsMenuVo> getSelfMenu() {
        UmsSysUserVo user = (UmsSysUserVo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Long> roleIds = user.getRoleList().stream().map(UmsRole::getRoleId).collect(Collectors.toSet());
        return buildMenuTree(umsMenuMapper.selectByRoleIds(roleIds));
    }

    @Override
    public List<UmsMenuVo> getMenuTree() {
        return buildMenuTree(list());
    }

    private List<UmsMenuVo> buildMenuTree(List<UmsMenu> menuList) {
        if (CollUtil.isEmpty(menuList)) return new ArrayList<>();
        List<UmsMenuVo> menuVoList = BeanUtil.copyToList(menuList.stream().sorted(Comparator.comparing(UmsMenu::getSort)).toList(), UmsMenuVo.class);
        menuVoList.forEach(menu -> {
            if (StringUtils.hasText(menu.getPath()) && !menu.getPath().startsWith("/")) {
                menu.setPath("/" + menu.getPath());
            }
        });
        List<UmsMenuVo> parentMenuList = menuVoList.stream().filter(menu -> menu.getParentId().equals(0L)).toList();
        dfs(parentMenuList, menuVoList);
        return parentMenuList;
    }

    private void dfs(List<UmsMenuVo> parentMenuList, List<UmsMenuVo> menuList) {
        for (UmsMenuVo menu : parentMenuList) {
            List<UmsMenuVo> children = menuList.stream().filter(subMenu -> subMenu.getParentId().equals(menu.getId())).toList();
            menu.setChildren(children);
            dfs(children, menuList);
        }
    }
}
