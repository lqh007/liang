package com.seven.controller;


import com.seven.common.utils.ApiResponse;
import com.seven.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Api(description = "用户列表")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${test.name}")
    private String name;


    @RequestMapping("/userList")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    public ApiResponse userList(){
        return userService.userList();
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping("/selectPage")
    public ApiResponse selectListPage(Integer pageNum,Integer pageSize){
        System.out.println("============="+name);
        return userService.selectListPage(pageNum,pageSize);
    }

}

