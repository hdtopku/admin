package com.demo.auth.domain.vo;

import com.demo.auth.domain.entity.UmsRole;
import com.demo.auth.domain.entity.UmsSysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.*;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-11 23:29:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UmsSysUserVo extends UmsSysUser implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<UmsRole> roleList=new ArrayList<>();
    private Set<String> perms = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perms.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getStatus()==0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getStatus()==0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.getStatus()==0;
    }

    @Override
    public boolean isEnabled() {
        return this.getStatus()==0;
    }
}
