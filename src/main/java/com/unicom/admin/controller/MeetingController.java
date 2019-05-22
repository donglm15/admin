package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Meeting;
import com.unicom.admin.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @RequestMapping(value = "list")
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
//            @RequestParam(name = "ifMoreid") int ifMoreid,
//            @RequestParam(name = "ifOpenid") int ifOpenid
//    ){
//        meetingService.insert(meetingName,meetingPosition,peopleNum,ifMoreid,ifOpenid);
//        return new JSONResult().ok("success");
//    }

    //后端分页以及查询
    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(name="page",defaultValue = "1") int page,
            @RequestParam(name="limit",defaultValue = "20") int limit,
            @RequestParam(name ="meetingName",defaultValue = "") String meetingName,
            @RequestParam(name ="peopleNum",defaultValue = "") String peopleNum,
            @RequestParam(name ="sort",defaultValue = "+id") String sort
    ){
        PageHelper.startPage(page,limit);//开启分页查询器

        List<Meeting> list=meetingService.getMeetingByCon(meetingName,peopleNum,sort);//根据条件查询数据

        PageInfo<Meeting> pageInfo=new PageInfo<>(list);//根据页码与当前页码一致的数据

        return new JSONResult().ok(pageInfo);
    }
}
