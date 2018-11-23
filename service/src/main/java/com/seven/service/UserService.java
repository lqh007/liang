package com.seven.service;

import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liang123
 * @since 2018-11-21
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    User selectUserById(Integer id);


}
