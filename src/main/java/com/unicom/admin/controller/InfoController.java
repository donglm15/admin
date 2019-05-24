package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Info;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "oldlist")
    public JSONResult getAllInfo(){
        List<Info> list = infoService.getAllInfo();
        return new JSONResult().ok(list);
    }

    @RequestMapping(value = "list")
    public JSONResult getInfoByCon(
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "limit",defaultValue = "10") int limit,
            @RequestParam(name = "title",defaultValue = "") String title,
            @RequestParam(name = "type",defaultValue = "") String type
    ){
        PageHelper.startPage(page,limit);
        List<Info> list = infoService.getInfoByCon(title,type);

        PageInfo<Info> pageInfo = new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }

    @RequestMapping(value = "updateByEdit")
    public JSONResult updateInfoByEdit(
            @RequestParam(name = "id",defaultValue = "0") int id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content,
            @RequestParam(name = "infoTypeId") int infoTypeId
    ){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        infoService.updateInfoByEdit(id,title,content,date,infoTypeId);

        return new JSONResult().ok("success");
    }

    @RequestMapping(value = "delete")
    public JSONResult delete(
            @RequestParam(name = "id") int id
    ){
                infoService.deleteInfoByd(id);
                return new JSONResult().ok("success");
    }

    @RequestMapping(value = "infoDetail/{id}")
    public JSONResult getInfoById(@PathVariable(name = "id") int id){
         Info info = infoService.getInfoById(id);
         return new JSONResult().ok(info);
    }

    @RequestMapping(value = "updateRead")
    public JSONResult updateRead(
            @RequestParam(name = "id") int id
    ){
        infoService.updateRead(id);
        return new JSONResult().ok("success");
    }

    @RequestMapping(value = "updateLikeFavo")
    public JSONResult updateLikeFavo(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "likeFlag") boolean likeFlag,
            @RequestParam(name = "flag") boolean flag
    ){
        infoService.updateLikeFavo(id,likeFlag,flag);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "insert")
    public JSONResult insert(@RequestBody Info info){
                infoService.insert(info);
                return new JSONResult().ok("success");
    }
}
