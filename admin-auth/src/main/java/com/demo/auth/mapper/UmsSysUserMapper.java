package com.demo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.auth.domain.entity.UmsSysUser;
import com.demo.auth.domain.vo.UmsSysUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsSysUserMapper extends BaseMapper<UmsSysUser> {
    UmsSysUserVo selectByUsername(@Param("account") String account);
}
