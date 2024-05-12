package com.demo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.auth.domain.entity.UmsMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:14:03
 */
@Mapper
public interface UmsMenuMapper extends BaseMapper<UmsMenu> {
    List<UmsMenu> selectByRoleIds(@Param("roleIds") Set<Long> roleIds);
}
