package com.seven.controller;


import com.seven.common.utils.ApiResponse;
import com.seven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liang123
 * @since 2018-11-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public ApiResponse userList(){
        return userService.userList();
    }

    @RequestMapping("/selectPage")
    public ApiResponse selectListPage(Integer pageNum,Integer pageSize){
        return userService.selectListPage(pageNum,pageSize);
    }

}

