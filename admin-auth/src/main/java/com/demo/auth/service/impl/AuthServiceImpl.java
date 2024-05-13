package com.demo.auth.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.demo.auth.constants.RedisCacheNames;
import com.demo.auth.domain.vo.UmsSysUserVo;
import com.demo.auth.service.IAuthService;
import com.demo.common.service.RedisService;
import com.demo.core.utils.JwtTokenUtil;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-11 22:39:43
 */
@Service
public class AuthServiceImpl implements IAuthService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisService redisService;

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            UmsSysUserVo user= (UmsSysUserVo) authenticate.getPrincipal();
            user.setLoginTime(System.currentTimeMillis());
            String uuid = IdUtil.simpleUUID();
            user.setToken(uuid);
            redisService.set(RedisCacheNames.LOGIN_TOKEN_KEY+uuid, user, JwtTokenUtil.JWT_TOKEN_EXPIRATION_SECONDS, TimeUnit.SECONDS);
            return JwtTokenUtil.generateToken(MapUtil.of("sub", uuid));
        } catch(BadCredentialsException | UsernameNotFoundException e) {
            throw new UsernameNotFoundException("用户名或密码错误");
        } catch(LockedException e) {
            throw new LockedException("用户已被锁定");
        } catch (DisabledException e) {
            throw new DisabledException("用户已被禁用");
        } catch (AccountExpiredException e) {
            throw new AccountExpiredException("用户账号已过期");
        } catch (CredentialsExpiredException e) {
            throw new CredentialsExpiredException("用户密码已过期");
        }
    }
}
