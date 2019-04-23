package com.seven.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.common.utils.ApiResponse;
import com.seven.mybatis_plus.entity.User;
import com.seven.mybatis_plus.mapper.UserMapper;
import com.seven.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public  ApiResponse saveUser() {
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setPhone("18093443226");
        user.setToken("1");
        user.setTokenCreateTime(LocalDateTime.now());
        return ApiResponse.success(userMapper.insert(user));
    }

    @Override
    public ApiResponse updUser(String id) {

        User user = new User();
        user.setId(id);
        user.setCreateTime(LocalDateTime.now());
        user.setPhone("18093443226");
        user.setToken("1");
        user.setTokenCreateTime(LocalDateTime.now());
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("id","fsf");
        return ApiResponse.success(userMapper.update(user, updateWrapper));
    }

    @Override
    public ApiResponse delUser(String id) {
        return null;
    }

    @Override
    public ApiResponse selectUser(String id) {
        Page page = new Page(1, 10,true);
        IPage iPage = userMapper.selectMapsPage(page, null);
        return ApiResponse.success(iPage);
    }



}
