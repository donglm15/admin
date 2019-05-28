package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Meeting;
import com.unicom.admin.service.MeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "meeting")
@Api(tags = "联通之家-会议管理(会议室)模块")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @ApiOperation(value="获取所有会议室信息列表(没有后端分页)")
    @GetMapping(value = "list")
    //显示全部数据
    public JSONResult getAllNews(){
        List<Meeting> list=meetingService.getAllMeeting();
        return new JSONResult().ok(list);
    }
//    //新增(get)
//    @RequestMapping(value = "create")
//    //@RequestParam以name
//    public JSONResult insert(
//            @RequestParam(name="meetingName") String meetingName,
//            @RequestParam(name = "meetingPosition") String meetingPosition,
//            @RequestParam(name = "peopleNum") int peopleNum,
//            @RequestParam(name = "ifMore") int ifMore,
//            @RequestParam(name = "ifOpen") int ifOpen
//    ){
//        meetingService.insert(meetingName,meetingPosition,peopleNum,ifMore,ifOpen);
//        return new JSONResult().ok("success");
//    }
    //后端分页以及查询
    @GetMapping(value = "select")
    @ApiOperation(value="获取当前页面会议室信息列表(后端分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码(默认第1页)",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页显示多少条（默认为20）",dataType = "int"),
            @ApiImplicitParam(name="meetingName",value="会议室名称",dataType = "String"),
            @ApiImplicitParam(name="peopleNum",value="可容纳人数",dataType = "String"),
            @ApiImplicitParam(name="sort",value="排序方式",dataType = "String"),
    })
    public JSONResult select(
            @RequestParam(name="page",defaultValue = "1") Integer page,
            @RequestParam(name="limit",defaultValue = "20") Integer limit,
            @RequestParam(name ="meetingName",defaultValue = "") String meetingName,
            @RequestParam(name ="peopleNum",defaultValue = "") String peopleNum,
            @RequestParam(name ="sort",defaultValue = "-id") String order
    ){
        PageHelper.startPage(page,limit);//开启分页查询器

        List<Meeting> list=meetingService.getMeetingByCon(meetingName,peopleNum,order);//根据条件查询数据

        PageInfo<Meeting> pageInfo=new PageInfo<>(list);//根据页码与当前页码一致的数据

        return new JSONResult().ok(pageInfo);
    }
    //删除
    @GetMapping(value = "delete")
    @ApiOperation(value="删除会议室信息")
    @ApiImplicitParam(name="id",value="要删除会议室的id值",required = true,dataType = "int")
    public JSONResult delete(@RequestParam(name ="id") int id){
        meetingService.delete(id);
        return new JSONResult().ok("success");
    }
    //新增
    @PostMapping(value = "saveOne")
    @ApiOperation(value="新增1条会议室数据(Post方式)")
    @ApiImplicitParam(name="meeting",value="Meeting(会议室实体类)",required = true,dataType = "Json")
    public JSONResult saveOne(@RequestBody Meeting meeting){
        System.out.println(meeting);
        meetingService.insertOne(meeting);
        return new JSONResult().ok("success");
    }
    //修改get
//    @RequestMapping(value = "update")
//    public JSONResult update(
//            @RequestParam(name="id") int id,
//            @RequestParam(name="meetingName") String meetingName,
//            @RequestParam(name = "meetingPosition") String meetingPosition,
//            @RequestParam(name = "peopleNum") int peopleNum,
//            @RequestParam(name = "ifMore") int ifMore,
//            @RequestParam(name = "ifOpen") int ifOpen
//    ){
//
//        meetingService.update(id,meetingName,meetingPosition,peopleNum,ifMore,ifOpen);
//        return new JSONResult().ok("success");
//    }
    //修改post
    @PostMapping(value = "update")
    @ApiOperation(value="修改1条会议室数据(Post方式)")
    @ApiImplicitParam(name="meeting",value="Meeting(会议室实体类)",required = true,dataType = "Json")
    public JSONResult update(@RequestBody Meeting meeting){
        meetingService.update(meeting);
        JSONResult result=new JSONResult().ok("success");
        return result;
    }
}
