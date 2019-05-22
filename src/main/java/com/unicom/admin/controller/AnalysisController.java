package com.unicom.admin.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Analysis;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "analysis")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;


    @RequestMapping(value = "list")
    public JSONResult getAllNews(){
        List<Analysis> list= analysisService.getAll();
       return new JSONResult().ok(list);
    }


    @RequestMapping(value = "insert")
    public JSONResult insert(
            String product,String date,int region,int person,float billing,float tratio,float hratio){
        analysisService.insert(product,date,region,person,billing,tratio,hratio);
        JSONResult result=new JSONResult().ok("success");
        return result;
    }

    @PostMapping(value = "update")
    public JSONResult update(@RequestBody Analysis analysis){
        analysisService.update(analysis);
        JSONResult result=new JSONResult().ok("success");
        return result;
    }

    @RequestMapping(value = "delete")
    public JSONResult delete(int id){
        analysisService.delete(id);
        JSONResult result=new JSONResult().ok("success");
        return result;
    }


    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "20") int limit,
            @RequestParam(value = "startdate",defaultValue = "") String startDate,
            @RequestParam(value = "enddate",defaultValue = "") String endDate,
            @RequestParam(value = "region",defaultValue = "") String region,
            @RequestParam(value = "product",defaultValue = "") String product
    ){
        PageHelper.startPage(page,limit);
        List<Analysis> list=analysisService.getByCon(startDate,endDate,region,product);
        PageInfo<Analysis> pageInfo=new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }

}
