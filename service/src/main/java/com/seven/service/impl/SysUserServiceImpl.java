package com.seven.service.impl;

import com.seven.common.utils.ApiResponse;
import com.seven.dao.entity.SysRoleResource;
import com.seven.dao.entity.SysUser;
import com.seven.dao.entity.SysUserRole;
import com.seven.dao.mapper.SysResourceMapper;
import com.seven.dao.mapper.SysRoleResourceMapper;
import com.seven.dao.mapper.SysUserMapper;
import com.seven.dao.mapper.SysUserRoleMapper;
import com.seven.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private SysRoleResourceMapper roleResourceMapper;
    @Resource
    private SysResourceMapper resourceMapper;



    @Override
    public SysUser getSysUserByUserName(String userName) {

        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("userName", userName);

        List<SysUser> sysUsers = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(sysUsers)) {
            return sysUsers.get(0);
        }

        return null;
    }

    @Override
    public List<String> getResourceListByUserId(Integer userId) {
        List<String> resourceList = new ArrayList<>();

        Example example = new Example(SysUserRole.class);
        example.createCriteria().andEqualTo("uid", userId);
        List<SysUserRole> sysUserRoles = userRoleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(sysUserRoles)){
            List<SysRoleResource> roleResourceList = new ArrayList<>();

            for (SysUserRole sysUserRole : sysUserRoles) {
                Example example1 = new Example(SysRoleResource.class);
                example1.createCriteria().andEqualTo("roleId", sysUserRole.getRoleId());
                roleResourceList.addAll(roleResourceMapper.selectByExample(example1));
            }
            if(!CollectionUtils.isEmpty(roleResourceList)){
                for (SysRoleResource sysRoleResource : roleResourceList) {
                    resourceList.add(resourceMapper.selectByPrimaryKey(sysRoleResource.getPermissionId()).getUrl());
                }
            }
        }

        return resourceList;
    }

    @Override
    public ApiResponse saveUser(SysUser user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(StringUtils.isEmpty(user.getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode("123456"));
        }else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        int insert = userMapper.insert(user);
        if(insert>0){
            return ApiResponse.success();
        }
        return ApiResponse.error("发生异常!");
    }
}
