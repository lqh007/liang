package com.seven.service;

import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.SysUser;

import java.util.List;

public interface SysUserService {
    SysUser getSysUserByUserName(String userName);

    List<String> getResourceListByUserId(Integer userId);

    ApiResponse saveUser(SysUser user);
}
