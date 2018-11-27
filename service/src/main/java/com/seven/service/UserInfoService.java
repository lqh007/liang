package com.seven.service;

import com.seven.dao.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);

}
