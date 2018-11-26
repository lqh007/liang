package com.seven.service;

import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liang123
 * @since 2018-11-26
 */
public interface UserService extends IService<User> {

    ApiResponse userList();

    ApiResponse selectListPage(Integer pageNum, Integer pageSize);
}
