package com.seven.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.User;
import com.seven.dao.mapper.UserMapper;
import com.seven.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Liang123
 * @since 2018-11-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ApiResponse userList() {

        EntityWrapper ew = new EntityWrapper();
        ew.setEntity(new User());
//        ew.where("id = {0}",1);
//        List<User> list = userMapper.selectList(ew);
        List<User> list = userMapper.selectBysql();
        return ApiResponse.success(list);
    }

    @Override
    public ApiResponse selectListPage(Integer pageNum, Integer pageSize) {
        Page page= new Page<>();
        page.setSize(pageSize);
        page.setLimit(pageNum);
        List<User> list = userMapper.selectListPage(page);
        return ApiResponse.success(list);
    }
}
