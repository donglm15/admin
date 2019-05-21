package com.unicom.admin.controller;

import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Market;
import com.unicom.admin.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "market")
public class MarketController {
    @Autowired
    private MarketService marketService;
    @RequestMapping(value = "list")
    public JSONResult getAllMarket(){
        List<Market> list = marketService.getAllMarket();
        return  new JSONResult().ok(list);
    }
}
