package com.seven.dao.entity;

import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    private Integer uid;

    private String userName;

    /**
     * 名称(昵称或者真实姓名，不同系统不同定义)
     */
    private String name;

    private String password;

    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private String state;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取名称(昵称或者真实姓名，不同系统不同定义)
     *
     * @return name - 名称(昵称或者真实姓名，不同系统不同定义)
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称(昵称或者真实姓名，不同系统不同定义)
     *
     * @param name 名称(昵称或者真实姓名，不同系统不同定义)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取加密密码的盐
     *
     * @return salt - 加密密码的盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密密码的盐
     *
     * @param salt 加密密码的盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     *
     * @return state - 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    public String getState() {
        return state;
    }

    /**
     * 设置用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     *
     * @param state 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    public void setState(String state) {
        this.state = state;
    }
}