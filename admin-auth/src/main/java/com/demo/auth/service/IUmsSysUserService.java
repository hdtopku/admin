package com.demo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.auth.domain.entity.UmsSysUser;
import com.demo.auth.domain.vo.UmsSysUserInfoVo;

public interface IUmsSysUserService extends IService<UmsSysUser>  {
    UmsSysUserInfoVo getUserInfo();
}
