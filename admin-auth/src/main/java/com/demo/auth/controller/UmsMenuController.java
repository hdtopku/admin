package com.demo.auth.controller;

import com.demo.auth.domain.vo.UmsMenuVo;
import com.demo.auth.service.impl.UmsMenuServiceImpl;
import com.demo.common.response.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lxh at 2024-05-13 14:27:51
 */
@RestController
@RequestMapping("/ums/menu")
public class UmsMenuController {
    @Resource
    private UmsMenuServiceImpl menuService;
    @GetMapping("/self")
    public Result<List<UmsMenuVo>> getSelfMenu() {
        return Result.success(menuService.getSelfMenu());
    }

}
