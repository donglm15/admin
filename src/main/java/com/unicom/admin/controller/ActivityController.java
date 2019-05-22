package com.unicom.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Activity;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.ActivityService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "list")
    public JSONResult getAllActivity(){
        List<Activity> list = activityService.getAllActivity();
        return new JSONResult().ok(list);
    }


    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "startTime", defaultValue = "") String startTime,
            @RequestParam(value = "endTime", defaultValue = "") String endTime,
            @RequestParam(value = "order" , defaultValue = "-id") String order
    ) throws Exception{
        PageHelper.startPage(page,limit);
        List<Activity> list = activityService.getCon(title,type,startTime,endTime,order);

        PageInfo<Activity> pageInfo = new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }

    @GetMapping(value = "delete")
    public JSONResult deleteActivity(@RequestParam(name = "id") int id){
        activityService.deleteActivity(id);
        return new JSONResult().ok("删除成功");
    }


    @PostMapping(value = "insert")
    public JSONResult insertActivity(@RequestBody Activity activity){
        activityService.insertActivity(activity);
        return new JSONResult().ok("新增成功");
    }

    @GetMapping(value = "update")
    public JSONResult updateActivity(@Param(value = "people") String people, @Param(value = "prize") String prize, @Param(value = "title") String title, @Param(value = "content") String content, @Param(value = "startTime") String startTime, @Param(value = "endTime") String endTime, @Param(value = "id") int id){
        try {
            activityService.updateActivity(people,prize,title,content,new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime),new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endTime),id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new JSONResult().ok("更新成功");
    }
}
