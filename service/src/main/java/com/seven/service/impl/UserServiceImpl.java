package com.seven.service.impl;

import com.seven.dao.entity.User;
import com.seven.dao.mapper.UserMapper;
import com.seven.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liang123
 * @since 2018-11-21
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }
}
