package com.unicom.admin.controller;

import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.User;
import com.unicom.admin.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* 需求描述：用户管理，接收前端请求并返回数据的controller层
* author:liufeng
* time:2019.05.21 16:00
* */

//控制器：接收前端请求，访问数据库，返回数据(JSON格式)给前端
@RestController
//说明控制器响应的是前端哪个请求的路径
@RequestMapping(value = "userManager")
public class UserManagerController {
    @Autowired
    private UserManagerService userManagerService;

    //查询所有用户信息列表
    //http://localhost:8080/user/list
    @RequestMapping(value = "list")
    //往List列表中放入News类型的数据(范型)
    public JSONResult getAllUser(){
        List<User> list = userManagerService.getAllUser();
        return new JSONResult().ok(list);
    }
}
