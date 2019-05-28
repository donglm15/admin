package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Announcement;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.AnnouncementService;
import com.unicom.admin.service.MeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "announcement")
@Api(tags = "联通之家-会议管理(会议通知)模块")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    //会议室地点数据封装
    @Autowired
    private MeetingService meetingService;

    @ApiOperation(value="获取所有会议通知信息列表(没有后端分页)")
    @GetMapping(value = "list")
    public JSONResult getAllAnnouncement(){
        List<Announcement> list=announcementService.getAllAnnouncement();
        return new JSONResult().ok(list);
    }
    //后端分页以及查询
    @GetMapping(value = "select")
    @ApiOperation(value="获取当前页面会议通知信息列表(后端分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码(默认第1页)",dataType = "int"),
            @ApiImplicitParam(name="limit",value="每页显示多少条（默认为20）",dataType = "int"),
            @ApiImplicitParam(name="meetingID",value="会议通知ID",dataType = "String"),
            @ApiImplicitParam(name="meetingStatus",value="会议状态（1:草稿,2：已通知,3：延迟，4：取消）",dataType = "String"),
            @ApiImplicitParam(name="meetingPosition",value="会议地点",dataType = "String"),
            @ApiImplicitParam(name="department",value="招开部门",dataType = "String"),
            @ApiImplicitParam(name="meetingTheme",value="会议主题",dataType = "String"),
            @ApiImplicitParam(name="startDateTime",value="起始时间",dataType = "String"),
            @ApiImplicitParam(name="endDateTime",value="截止时间",dataType = "String"),
    })
    public JSONResult select(
            @RequestParam(name="page",defaultValue = "1") Integer page,
            @RequestParam(name="limit",defaultValue = "20") Integer limit,
            @RequestParam(name ="meetingID",defaultValue = "") String meetingID,
            @RequestParam(name ="meetingStatus",defaultValue = "") String meetingStatus,
            @RequestParam(name ="meetingPosition",defaultValue = "") String meetingPosition,
            @RequestParam(name ="department",defaultValue = "") String department,
            @RequestParam(name ="meetingTheme",defaultValue = "") String meetingTheme,
            @RequestParam(name ="startDateTime",defaultValue = "") String startDateTime,
            @RequestParam(name ="endDateTime",defaultValue = "") String endDateTime
    ){
        PageHelper.startPage(page,limit);//开启分页查询器

        List<Announcement> list=announcementService.getAnnouncementByCon(meetingID,meetingStatus,meetingPosition,department,
                meetingTheme,startDateTime,endDateTime);//根据条件查询数据

        PageInfo<Announcement> pageInfo=new PageInfo<>(list);//根据页码与当前页码一致的数据

        return new JSONResult().ok(pageInfo);
    }

    //会议室地点数据封装
    @GetMapping(value = "getMeetingPlace")
    @ApiOperation(value="会议地点")
    @ApiImplicitParam(name="meeting",value="Meeting(会议实体类)",required = true,dataType = "Json")
    public JSONResult getMeetingPlace(){
        return new JSONResult().ok(meetingService.getMeetingPlace());
    }


    //删除
    @GetMapping(value = "delete")
    @ApiOperation(value="删除会议通知信息")
    @ApiImplicitParam(name="id",value="要删除会议通知的id值",required = true,dataType = "int")
    public JSONResult delete(@RequestParam(name ="id") int id){
        announcementService.delete(id);
        return new JSONResult().ok("success");
    }

    //新增
    @PostMapping(value = "saveOne")
    @ApiOperation(value="新增1条会议通知数据(Post方式)")
    @ApiImplicitParam(name="announcement",value="Announcement(通知实体类)",required = true,dataType = "Json")
    public JSONResult saveOne(@RequestBody Announcement announcement){
//        System.out.println(announcement);
        announcementService.insertOne(announcement);
        return new JSONResult().ok("success");
    }
    //修改延迟post
//    @PutMapping(value = "delay/{statusid}")
//    public JSONResult update(
//            @PathVariable(name = "statusid") int statusid,
//            @RequestBody Announcement announcement){
//        announcementService.update(statusid,announcement);
//        JSONResult result=new JSONResult().ok("success");
//        return result;
//    }
    @PutMapping(value = "delay")
    @ApiOperation(value="修改1条会议通知数据(Post方式)")
    @ApiImplicitParam(name="announcement",value="Announcement(通知实体类)",required = true,dataType = "Json")
    public JSONResult update(
//            @PathVariable(name = "statusid") int statusid,
            @RequestBody Announcement announcement){
        System.out.println(announcement);
        announcementService.update(announcement);
        JSONResult result=new JSONResult().ok("success");
        return result;
    }
}
