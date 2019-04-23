package com.seven.service;

import com.seven.common.utils.ApiResponse;

public interface UserService {

    ApiResponse saveUser();
    ApiResponse updUser(String id);
    ApiResponse delUser(String id);
    ApiResponse selectUser(String id);

}
