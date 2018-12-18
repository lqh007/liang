package com.seven.service.impl;

import com.seven.dao.entity.SysUser;
import com.seven.service.AuthenticationService;
import com.seven.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service(value = "authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private SysUserService userService;
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        Object principal = authentication.getPrincipal();
        boolean hasPermisson = false;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            SysUser user = userService.getSysUserByUserName(username);
            if(user==null){
                return hasPermisson;
            }
            List<String> urlList = userService.getResourceListByUserId(user.getUid());

            for (String url : urlList) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermisson = true;
                    break;
                }

            }
        }
        return hasPermisson;
    }
}
