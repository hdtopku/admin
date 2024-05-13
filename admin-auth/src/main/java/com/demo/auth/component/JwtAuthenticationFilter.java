package com.demo.auth.component;

import com.demo.auth.constants.RedisCacheNames;
import com.demo.auth.domain.vo.UmsSysUserVo;
import com.demo.common.service.RedisService;
import com.demo.core.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Created by lxh at 2024-05-13 10:09:51
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    private RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token)) {
            try {
                Claims claims = JwtTokenUtil.parseToken(token);
                String tokenKey = RedisCacheNames.LOGIN_TOKEN_KEY + claims.getSubject();
                UmsSysUserVo sysUserVo = (UmsSysUserVo) redisService.get(tokenKey);
                if (sysUserVo != null) {
                    UsernamePasswordAuthenticationToken authenticated = UsernamePasswordAuthenticationToken.authenticated(sysUserVo, null, sysUserVo.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticated);
                    // 刷新 token
                    if ((System.currentTimeMillis() - sysUserVo.getLoginTime() >= 30 * 60 * 1000)) {
                        redisService.expire(tokenKey, JwtTokenUtil.JWT_TOKEN_EXPIRATION_SECONDS);
                    }
                }
            } catch (Exception e) {
                response.sendError(401, "登录过期，请重新登录");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
