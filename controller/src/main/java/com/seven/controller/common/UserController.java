package com.seven.controller.common;


import com.seven.common.utils.ApiResponse;
import com.seven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author seven
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/User/user")
public class UserController  {
    @Autowired
    private UserService userService;
    @GetMapping("selectUser")
    public ApiResponse selectUser(String id){
        return userService.selectUser(id);
    }

}

