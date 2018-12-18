package com.seven.support;

import com.seven.dao.entity.SysUser;
import com.seven.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;

    private BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser userInfo = userService.getSysUserByUserName(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(username, userInfo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

    }
}
