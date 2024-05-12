package com.demo.auth.controller;

import com.demo.auth.domain.dto.LoginParam;
import com.demo.auth.service.IAuthService;
import com.demo.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-11 20:12:58
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private IAuthService authService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        return Result.success(authService.login(loginParam.getUsername(), loginParam.getPassword()));
    }
}
