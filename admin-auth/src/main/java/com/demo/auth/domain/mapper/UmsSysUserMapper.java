package com.demo.auth.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.auth.domain.entity.UmsSysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsSysUserMapper extends BaseMapper<UmsSysUser> {
}
