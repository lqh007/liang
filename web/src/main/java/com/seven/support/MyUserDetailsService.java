package com.seven.support;

import com.seven.dao.entity.SysPermission;
import com.seven.dao.entity.SysRole;
import com.seven.dao.entity.UserInfo;
import com.seven.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.findByUsername(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException(username);
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : userInfo.getRoleList()) {
            for (SysPermission permission : role.getPermissionList()) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }

        //添加拥有的资源code
        authorities.add(new SimpleGrantedAuthority(""));
        return new User(userInfo.getUsername(), userInfo.getPassword(), authorities);

    }
}
