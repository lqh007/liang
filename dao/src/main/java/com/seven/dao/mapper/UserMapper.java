package com.seven.dao.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.seven.dao.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liang123
 * @since 2018-11-26
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectBysql();

    List<User> selectListPage(Page page);
}
