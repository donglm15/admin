package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Announcement;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.AnnouncementService;
import com.unicom.admin.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    //会议室地点数据封装
    @Autowired
    private MeetingService meetingService;


    @GetMapping(value = "list")
    public JSONResult getAllAnnouncement(){
        List<Announcement> list=announcementService.getAllAnnouncement();
        return new JSONResult().ok(list);
    }
    //后端分页以及查询
    @GetMapping(value = "select")
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
    @RequestMapping(value = "getMeetingPlace")
    public JSONResult getMeetingPlace(){
        return new JSONResult().ok(meetingService.getMeetingPlace());
    }


    //删除
    @RequestMapping(value = "delete")
    public JSONResult delete(@RequestParam(name ="id") int id){
        announcementService.delete(id);
        return new JSONResult().ok("success");
    }

    //新增
    @PostMapping(value = "saveOne")
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
    public JSONResult update(
//            @PathVariable(name = "statusid") int statusid,
            @RequestBody Announcement announcement){
        announcementService.update(announcement);
        JSONResult result=new JSONResult().ok("success");
        return result;
    }
}
