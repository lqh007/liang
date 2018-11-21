package com.seven.controller;


import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.User;
import com.seven.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liang123
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/dao/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/insertUser")
    public ApiResponse insertUser(User user){
        return userService.insertUser(user);
    }

    @RequestMapping("/selectUserList")
    public ApiResponse selectUserList(){
        return userService.selectUserList();
    }

}

