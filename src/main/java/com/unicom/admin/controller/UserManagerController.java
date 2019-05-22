package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.User;
import com.unicom.admin.model.position;
import com.unicom.admin.service.UserManagerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //后端分页查询
    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(name="page",defaultValue = "1") int page,
            @RequestParam(name="limit",defaultValue = "20") int limit,
            @RequestParam(name="account",defaultValue = "") String account,
            @RequestParam(name="position",defaultValue = "") String position,
            @RequestParam(name="userName",defaultValue = "") String userName,
            @RequestParam(name="Organization",defaultValue = "") String Organization,
            @RequestParam(name="employeeNumber",defaultValue = "") String employeeNumber,
            @RequestParam(name="phone",defaultValue = "") String phone,
            @RequestParam(name="startDateTime",defaultValue = "") String startDateTime,
            @RequestParam(name="endDateTime",defaultValue = "") String endDateTime,
            @RequestParam(name="sort",defaultValue = "+id") String order
    ){
        PageHelper.startPage(page,limit);//开启分页
        List<User> list = userManagerService.getUserByCondition(account,userName,Organization,position,employeeNumber,phone,startDateTime,endDateTime,order);  //根据条件查询数据
        PageInfo<User> pageInfo = new PageInfo<>(list);  //取页码与当前页码一致的数据
        return new JSONResult().ok(pageInfo);
    }

    //新增用户数据（get方式）
    @GetMapping(value = "save")
    @ApiOperation(value = "插入新的用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="position",value="用户职位（int型）",required = true,dataType = "string"),
            @ApiImplicitParam(name="lastLoginTime",value="设置用户的登录时间（String）",required = true,dataType = "string")
    })
    public JSONResult insert(  //URL中以？形式传入的请求路径当中的参数
            @RequestParam(name="account") String account,
            @RequestParam(name="userName") String userName,
            @RequestParam(name="Organization") String Organization,
            @RequestParam(name="position") int position,
            @RequestParam(name="employeeNumber") String employeeNumber,
            @RequestParam(name="phone") String phone,
            @RequestParam(name="lastLoginTime") String lastLoginTime
    ) {
        userManagerService.insert(account, userName, Organization, position, employeeNumber,phone,lastLoginTime);
        return new JSONResult().ok("success");
    }

    //新增（post）
    @PostMapping(value = "saveOne")
    public JSONResult saveOne(@RequestBody User user){
        userManagerService.insert(user);
        return new JSONResult().ok("success");
    }

    //查看用户详情
    @RequestMapping(value = "getUser/{id}")
    public JSONResult getUserById(@PathVariable(name="id") int id){
        User user = userManagerService.getUserById(id);
        return new JSONResult().ok(user);
    }

    //由id编辑（修改）一条用户信息
    @RequestMapping(value = "update")
    public JSONResult update(
            @RequestParam(name="id") int id,
            @RequestParam(name="account") String account,
            @RequestParam(name="userName") String userName,
            @RequestParam(name="Organization") String Organization,
            @RequestParam(name="position") int position,
            @RequestParam(name="employeeNumber") String employeeNumber,
            @RequestParam(name="phone") String phone,
            @RequestParam(name="lastLoginTime") String lastLoginTime
            ){
        userManagerService.updateUser(id,account,userName,Organization,position,employeeNumber,phone,lastLoginTime);
        return new JSONResult().ok("success");
    }
}
