package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Notice;
import com.unicom.admin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping(value="list")
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
    public JSONResult getALLPublish(){
       ArrayList<String> list=noticeService.getAllPublish();
        return new JSONResult().ok(list);
    }

    @GetMapping(value = "delete")
    public JSONResult deleteNotice(@RequestParam(name = "noticeId") int noticeId){
        noticeService.deleteNotice(noticeId);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "insert")
    public JSONResult insertNotice(@RequestBody Notice notice){
        noticeService.insertNotice(notice);
        return new JSONResult().ok("success");
    }

    @GetMapping(value = "getOneNotice")
    public JSONResult getOneNotice(@RequestParam(name = "noticeId") int noticeId){
        Notice notice=noticeService.getOneNotice(noticeId);
        return new JSONResult().ok(notice);
    }

    @PostMapping(value = "update")
    public JSONResult updateNotice(@RequestBody Notice notice){
        noticeService.updateNotice(notice);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "updateOne")
    public JSONResult updateStatus(@RequestParam(name = "noticeId") int noticeId,@RequestParam(name = "noticeStatus") String noticeStatus){
        noticeService.updateStatus(noticeId,noticeStatus);
        return new JSONResult().ok("success");
    }
}
