package com.demo.auth.controller;

import com.demo.auth.domain.entity.UmsSysUser;
import com.demo.auth.service.impl.UmsSysUserService;
import com.demo.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 21:51:15
 */
@RestController
@RequestMapping("/ums/sys/user")
public class UmsSysUserController {
    @Resource
    private UmsSysUserService umsSysUserService;

    @PostMapping("/add")
    public Result addUser(@RequestBody UmsSysUser user) {
        boolean success = umsSysUserService.save(user);
        if (!success) {
            return Result.fail("添加用户失败");
        }
        return Result.success();
    }

    @GetMapping("/list")
    public Result userList() {
        return Result.success(umsSysUserService.list());
    }
}
