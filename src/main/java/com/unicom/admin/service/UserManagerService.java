package com.unicom.admin.service;

import com.unicom.admin.dao.UserDao;
import com.unicom.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 需求描述：用户管理，辅助controller层操作数据库的Service类
* author:liufeng
* time:2019.05.21 15:52
* */

//服务于访问数据库的操作
@Service
public class UserManagerService {
    @Autowired //对象实例会自动注入
    private UserDao userDao;

    //查询所有用户信息列表（没有后端分页）
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

    //后端分页查询
    public List<User> getUserByCondition(String account, String userName, String Organization,String position,String employeeNumber,String phone,String startDateTime,String endDateTime,String order){
        return userDao.getUserByCondition(account,userName,Organization,position,employeeNumber,phone,startDateTime,endDateTime,order);
    }

    //新增用户数据（get方式）
    public int insert(String account, String userName,
                      String Organization, int position, String employeeNumber,String phone,String lastLoginTime){
        return userDao.save(account, userName, Organization, position, employeeNumber,phone,lastLoginTime);
    }

    //新增用户数据（post方式）
    public int insert(User user){
        userDao.saveOne(user);
        System.out.println(user.getId());
        return user.getId();
    }

    //查看用户详情
    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    //由id编辑（修改）一条用户信息
    public int updateUser(int id,String account,String userName,
                          String Organization,int position,String employeeNumber,
                          String phone,String lastLoginTime){
        System.out.println(userName);
        return userDao.updateUser(id,account,userName,Organization,position,employeeNumber,phone,lastLoginTime);
    }

}
