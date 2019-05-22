package com.unicom.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Activity;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.ActivityService;
import io.swagger.annotations.*;
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
@Api(tags = "联通之家-活动管理模块")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping(value = "list")
    @ApiOperation(value = "获取活动列表")
    public JSONResult getAllActivity(){
        List<Activity> list = activityService.getAllActivity();
        return new JSONResult().ok(list);
    }


    @GetMapping(value = "select")
    @ApiOperation(value = "后台分页获取活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页码", required = true,dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页显示条数", required = true,dataType = "int"),
            @ApiImplicitParam(name = "title", value = "按活动名称搜索关键字",dataType = "string"),
            @ApiImplicitParam(name = "type", value = "活动状态",dataType = "string"),
            @ApiImplicitParam(name = "startTime", value = "活动开始时间",dataType = "string"),
            @ApiImplicitParam(name = "endTime", value = "活动结束时间",dataType = "string"),
            @ApiImplicitParam(name = "order", value = "活动排序", dataType = "string"),
    })
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

    @ApiOperation(value = "根据活动id删除活动")
    @ApiImplicitParam(name = "id",value = "活动id",required = true,dataType = "int")
    @GetMapping(value = "delete")
    public JSONResult deleteActivity(@RequestParam(name = "id") int id){
        activityService.deleteActivity(id);
        return new JSONResult().ok("删除成功");
    }


    @ApiOperation(value = "插入活动")
    @ApiImplicitParam(name = "activity", value = "活动数据", required = true, dataType = "Activity")
    @PostMapping(value = "insert")
    public JSONResult insertActivity(@RequestBody Activity activity){
        activityService.insertActivity(activity);
        return new JSONResult().ok("新增成功");
    }

    @ApiOperation(value = "更新活动")
    @GetMapping(value = "update")
    public JSONResult updateActivity(@RequestParam(value = "people") @ApiParam(value = "活动人数", required = true) String people,
                                     @RequestParam(value = "prize") @ApiParam(value = "活动奖品", required = true) String prize,
                                     @RequestParam(value = "title") @ApiParam(value = "活动名称", required = true) String title,
                                     @RequestParam(value = "content") @ApiParam(value = "活动内容", required = true) String content,
                                     @RequestParam(value = "startTime") @ApiParam(value = "活动开始时间", required = true) String startTime,
                                     @RequestParam(value = "endTime") @ApiParam(value = "活动结束时间", required = true) String endTime,
                                     @RequestParam(value = "id") @ApiParam(value = "活动id", required = true) int id){
        try {
            activityService.updateActivity(people,prize,title,content,new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime),new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endTime),id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new JSONResult().ok("更新成功");
    }
}
