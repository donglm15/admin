package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Info;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "info")
public class InfoController {

    @Autowired
    private InfoService infoService;

//    @RequestMapping(value = "oldlist")
//    public JSONResult getAllInfo(){
//        List<Info> list = infoService.getAllInfo();
//        return new JSONResult().ok(list);
//    }

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

}
