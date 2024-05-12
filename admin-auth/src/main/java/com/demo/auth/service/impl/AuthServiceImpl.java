package com.demo.auth.service.impl;

import com.demo.auth.domain.entity.UmsSysUser;
import com.demo.auth.service.IAuthService;
import com.demo.core.utils.JwtUtils;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-11 22:39:43
 */
@Service
public class AuthServiceImpl implements IAuthService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authenticate = authenticationManager.authenticate(token);
            UmsSysUser user= (UmsSysUser) authenticate.getPrincipal();
            return JwtUtils.generateToken(new HashMap<>());
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
