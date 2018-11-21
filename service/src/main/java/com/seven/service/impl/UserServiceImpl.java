package com.seven.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.User;
import com.seven.dao.mapper.UserMapper;
import com.seven.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liang123
 * @since 2018-11-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;


    public ApiResponse selectUserList() {
        Wrapper<User> wrapper = new EntityWrapper<User>();
        List<User> users = userMapper.selectList(wrapper);
        return ApiResponse.success(users);
    }

    public ApiResponse insertUser(User user) {
        Integer insert = userMapper.insert(user);
        return ApiResponse.success(insert);
    }
}
