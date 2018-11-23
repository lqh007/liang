package com.seven.controller;


import com.seven.dao.entity.User;
import com.seven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    private UserService userService;

    @RequestMapping("/selectUserList")
    public User selectUserList(Integer id){
        return userService.selectUserById(id);
    }

}

