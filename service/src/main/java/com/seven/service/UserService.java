package com.seven.service;

import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.User;
import com.baomidou.mybatisplus.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liang123
 * @since 2018-11-21
 */
public interface UserService extends IService<User> {
    /**
     * 查询所有用户
     * @return
     */
    ApiResponse selectUserList();

    /**
     * 添加用户接口
     * @param user
     * @return
     */
    ApiResponse insertUser(User user);

}
