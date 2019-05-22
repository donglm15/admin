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
    @ApiOperation(value="获取所有用户信息列表(没有后端分页)")
    @GetMapping(value = "list")
    //往List列表中放入News类型的数据(范型)
    public JSONResult getAllUser(){
        List<User> list = userManagerService.getAllUser();
        return new JSONResult().ok(list);
    }

    //后端分页查询
    @GetMapping(value = "select")
    @ApiOperation(value="获取当前页面用户信息列表(后端分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码(默认第1页)",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页显示多少条（默认为20）",dataType = "int"),
            @ApiImplicitParam(name="account",value="用户名",dataType = "String"),
            @ApiImplicitParam(name="position",value="职位类别（1:组长,2：主办,3：助理）",dataType = "String"),
            @ApiImplicitParam(name="userName",value="姓名",dataType = "String"),
            @ApiImplicitParam(name="Organization",value="组织机构",dataType = "String"),
            @ApiImplicitParam(name="employeeNumber",value="员工号",dataType = "String"),
            @ApiImplicitParam(name="phone",value="电话号码",dataType = "String"),
            @ApiImplicitParam(name="startDateTime",value="起始时间",dataType = "String"),
            @ApiImplicitParam(name="endDateTime",value="截止时间",dataType = "String"),
            @ApiImplicitParam(name="sort",value="排序方式",dataType = "String"),
    })
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
    @ApiOperation(value="新增1条用户数据(Get方式)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="account",value="用户名",required = true,dataType = "String"),
            @ApiImplicitParam(name="userName",value="姓名",required = true,dataType = "String"),
            @ApiImplicitParam(name="Organization",value="组织机构",required = true,dataType = "String"),
            @ApiImplicitParam(name="position",value="职位（1:组长,2：主办,3：助理）",required = true,dataType = "int"),
            @ApiImplicitParam(name="employeeNumber",value="员工号",required = true,dataType = "String"),
            @ApiImplicitParam(name="phone",value="电话号码",required = true,dataType = "String"),
            @ApiImplicitParam(name="lastLoginTime",value="最后登录时间",required = true,dataType = "String")
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
    @ApiOperation(value="新增1条用户数据(Post方式)")
    @ApiImplicitParam(name="user",value="User(用户实体类)",required = true,dataType = "Json")
    public JSONResult saveOne(@RequestBody User user){
        userManagerService.insert(user);
        return new JSONResult().ok("success");
    }

    //查看用户详情
    @GetMapping(value = "getUser/{id}")
    @ApiOperation(value="由id获取用户信息详情")
    @ApiImplicitParam(name="id",value="要查看用户的id值",required = true,dataType = "int")
    public JSONResult getUserById(@PathVariable(name="id") int id){
        User user = userManagerService.getUserById(id);
        return new JSONResult().ok(user);
    }

    //由id编辑（修改）一条用户信息(post方式)
    @PostMapping(value = "update")
    @ApiOperation(value="编辑用户信息")
    @ApiImplicitParam(name="user",value="User(用户实体类)",required = true,dataType = "Json")
    public JSONResult update(@RequestBody User user){
        userManagerService.updateUser(user);
        return new JSONResult().ok("success");
    }

//    //由id编辑（修改）一条用户信息（get方式）
//    @RequestMapping(value = "update")
//    public JSONResult update(
//            @RequestParam(name="id") int id,
//            @RequestParam(name="account") String account,
//            @RequestParam(name="userName") String userName,
//            @RequestParam(name="Organization") String Organization,
//            @RequestParam(name="position") int position,
//            @RequestParam(name="employeeNumber") String employeeNumber,
//            @RequestParam(name="phone") String phone,
//            @RequestParam(name="lastLoginTime") String lastLoginTime
//            ){
//        userManagerService.updateUser(id,account,userName,Organization,position,employeeNumber,phone,lastLoginTime);
//        return new JSONResult().ok("success");
//    }

    //删除
    @GetMapping(value = "delete")
    @ApiOperation(value="删除用户信息")
    @ApiImplicitParam(name="id",value="要删除用户的id值",required = true,dataType = "int")
    public JSONResult deleteUser(@RequestParam(name="id") int id){
        userManagerService.deleteUser(id);
        return new JSONResult().ok("success");
    }
}
