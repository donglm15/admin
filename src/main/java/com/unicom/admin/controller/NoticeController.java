package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Notice;
import com.unicom.admin.model.NoticeStatistics;
import com.unicom.admin.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "notice")
@Api(tags = "联通之家-通知管理模块")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping(value="list")
    @ApiOperation(value = "后台分页获取公告列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页码", required = true,dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页显示条数", required = true,dataType = "int"),
            @ApiImplicitParam(name = "noticeTitle", value = "公告标题",dataType = "string"),
            @ApiImplicitParam(name = "noticePublish", value = "发布部门",dataType = "string"),
            @ApiImplicitParam(name = "order", value = "排序方式",dataType = "string"),
            @ApiImplicitParam(name = "noticeStatus", value = "公告状态",dataType = "string")
    })
    public JSONResult getAllNotice(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit,
            @RequestParam(name = "noticeTitle",defaultValue = "") String noticeTitle,
            @RequestParam(name = "noticePublish",defaultValue = "") String noticePublish,
            @RequestParam(name = "order",defaultValue = "-id") String order,
            @RequestParam(name = "noticeStatus",defaultValue = "") String noticeStatus
    ){
        PageHelper.startPage(page,limit);
        List<Notice> list=noticeService.getAllNotices(noticeTitle,noticePublish,order,noticeStatus);
        PageInfo<Notice> pageINfo= new PageInfo<>(list);
        return new JSONResult().ok(pageINfo);
    }

    @GetMapping(value = "publish")
    @ApiOperation(value = "后台获取发布部门列表")
    public JSONResult getALLPublish(){
       ArrayList<String> list=noticeService.getAllPublish();
        return new JSONResult().ok(list);
    }

    @GetMapping(value = "delete")
    @ApiOperation(value = "根据公告编号删除公告")
    @ApiImplicitParam(name = "noticeId",value = "公告编号",required = true,dataType = "int")
    public JSONResult deleteNotice(@RequestParam(name = "noticeId") int noticeId){
        noticeService.deleteNotice(noticeId);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "insert")
    @ApiOperation(value = "插入新建公告")
    @ApiImplicitParam(name = "notice", value = "新建公告内容", required = true, dataType = "Notice")
    public JSONResult insertNotice(@RequestBody Notice notice){
        noticeService.insertNotice(notice);
        return new JSONResult().ok("success");
    }

    @GetMapping(value = "getOneNotice")
    @ApiOperation(value = "根据公告编号获取公告详情")
    @ApiImplicitParam(name = "noticeId",value = "公告编号",required = true,dataType = "int")
    public JSONResult getOneNotice(@RequestParam(name = "noticeId") int noticeId){
        Notice notice=noticeService.getOneNotice(noticeId);
        return new JSONResult().ok(notice);
    }

    @PostMapping(value = "update")
    @ApiOperation(value = "更新公告")
    @ApiImplicitParam(name = "notice", value = "更新公告内容", required = true, dataType = "Notice")
    public JSONResult updateNotice(@RequestBody Notice notice){
        noticeService.updateNotice(notice);
        return new JSONResult().ok("success");
    }

    @GetMapping(value = "updateStatus")
    @ApiOperation(value = "更新当前某条公告的状态信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeId", value = "公告编号", required = true,dataType = "int"),
            @ApiImplicitParam(name = "noticeStatus", value = "公告状态", required = true,dataType = "string"),
    })
    public JSONResult updateStatus(@RequestParam(name = "noticeId") int noticeId,@RequestParam(name = "noticeStatus") String noticeStatus){
        noticeService.updateStatus(noticeId,noticeStatus);
        return new JSONResult().ok("success");
    }

    @GetMapping(value = "noticeStatistics")
    @ApiOperation(value = "根据接收参数进行统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeFirst", value = "第一个参数", required = true,dataType = "String"),
            @ApiImplicitParam(name = "noticeSecond", value = "第二个参数", required = true,dataType = "string"),
    })
    public JSONResult noticeStatistics(@RequestParam(name = "noticeFirst") String noticeFirst,@RequestParam(name = "noticeSecond") String noticeSecond){
        List<NoticeStatistics> list=noticeService.noticeStatistics(noticeFirst,noticeSecond);
        System.out.println(list);
        return new JSONResult().ok(list);
    }

}
