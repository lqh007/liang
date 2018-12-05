package com.seven.controller;

import com.seven.dao.entity.UserInfo;
import com.seven.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 个人中心
     */
    @PreAuthorize("hasAuthority('UserIndex')")
    @GetMapping("/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        UserInfo sysUser = userInfoService.findByUsername("zhangsan");
        return sysUser.toString();
    }

}
