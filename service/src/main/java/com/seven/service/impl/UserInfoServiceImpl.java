package com.seven.service.impl;

import com.seven.dao.entity.UserDao;
import com.seven.dao.entity.UserInfo;
import com.seven.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserDao userDao;
    @Override
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = userDao.selectByName(username);
        return userInfo;
    }
}
