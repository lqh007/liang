package com.seven.dao.entity;


import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {

    SysRole admin = new SysRole("admin","系统管理员");
    SysRole developer = new SysRole("developer","开发者");

    {
        SysPermission p1 = new SysPermission();
        p1.setCode("UserIndex");
        p1.setName("个人中心");
        p1.setUrl("/user/index.html");

        SysPermission p2 = new SysPermission();
        p2.setCode("BookList");
        p2.setName("图书列表");
        p2.setUrl("/book/list");

        SysPermission p3 = new SysPermission();
        p3.setCode("BookAdd");
        p3.setName("添加图书");
        p3.setUrl("/book/add");

        SysPermission p4 = new SysPermission();
        p4.setCode("BookDetail");
        p4.setName("查看图书");
        p4.setUrl("/book/detail");

        admin.setPermissionList(Arrays.asList(p1, p2, p3, p4));
        developer.setPermissionList(Arrays.asList(p1, p2));

    }

    public UserInfo selectByName(String username) {
        System.out.println("从数据库中查询用户");
        if ("zhangsan".equals(username)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("zhangsan");
            userInfo.setPassword("$2a$10$rxQr9bR326R/4SY8bSYMO./ANVAsl4WCjiveHUvcq96SPt7Nw6gB");
            userInfo.setRoleList(Arrays.asList(admin, developer));
            return userInfo;
        } else if ("lisi".equals(username)) {
            UserInfo sysUser = new UserInfo();
            sysUser.setPassword("$2a$10$rxQr9bR326R/4SY8bSYMO./ANVAsl4WCjiveHUvcq96SPt7Nw6gB");
            sysUser.setRoleList(Arrays.asList(developer));
            return sysUser;
        }
        return null;
    }

}
