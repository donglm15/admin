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

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

}
