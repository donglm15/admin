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

import java.text.SimpleDateFormat;
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
            @RequestParam(value = "endTime", defaultValue = "") String endTime
    ) throws Exception{
        PageHelper.startPage(page,limit);
        List<Activity> list = activityService.getCon(title,type,startTime,endTime);

        PageInfo<Activity> pageInfo = new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }

    @RequestMapping(value = "delete")
    public JSONResult delete(@RequestParam(name = "id") int id){
        System.out.println("sakshakhdahda");
        activityService.deleteActivity(id);
        return new JSONResult().ok("删除成功");
    }

}
