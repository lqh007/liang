package com.seven.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.UserInfo;
import com.seven.dao.mapper.UserInfoMapper;
import com.seven.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo findByUsername(String username) {
        EntityWrapper ew = new EntityWrapper();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        ew.setEntity(new UserInfo());
        List<UserInfo> list = userInfoMapper.selectList(ew);

        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }
}
