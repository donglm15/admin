package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Market;
import com.unicom.admin.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "market")
public class MarketController {
    //前端查询表
    @Autowired
    private MarketService marketService;
    @RequestMapping(value = "list")
    public JSONResult getAllMarket(){
        List<Market> list = marketService.getAllMarket();
        return  new JSONResult().ok(list);
    }
    //后端分页get方法
    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(name="page",defaultValue = "1") Integer page,
            @RequestParam(name = "limit",defaultValue = "10") Integer limit,
            @RequestParam(name = "title",defaultValue = "") String title,
            @RequestParam(name = "importance",defaultValue = "") String importance,
            @RequestParam(name = "marketType",defaultValue = "") String marketType,
            @RequestParam(name = "sort",defaultValue = "+id") String sort
    )
    {
        PageHelper.startPage(page,limit);
        List<Market> list = marketService.getMarketByCon(title,importance,marketType,sort);
        PageInfo<Market> pageInfo = new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }
}
