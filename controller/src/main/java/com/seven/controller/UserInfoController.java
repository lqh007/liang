package com.seven.controller;

import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.SysUser;
import com.seven.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private SysUserService userService;

    /**
     * 用户查询.
     *
     * @return
     */
    @RequestMapping("/userList")
    public String userInfo() {
        return "userInfo";
    }


    /**
     * 用户添加;
     *
     * @return
     */
    @RequestMapping("/userAdd")
    public ApiResponse userInfoAdd(SysUser user) {
        return  userService.saveUser(user);
    }

    /**
     * 用户删除;
     *
     * @return
     */
    @RequestMapping("/userDel")
    public String userDel() {
        return "userInfoDel";
    }
}
