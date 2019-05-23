package com.unicom.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Analysis;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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


    @PostMapping(value = "insert")
    public JSONResult insert(@RequestBody Analysis analysis){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String d=analysis.getDate();
            long dif = df.parse(d).getTime()-86400*1000;//减一天
            Date date=new Date();
            date.setTime(dif);
            String lastDate=df.format(date);
            DecimalFormat fnum = new  DecimalFormat("##0.00");
            Random rand = new Random();
            float f = rand.nextInt(51)-20+rand.nextFloat();
            float t=Float.parseFloat(fnum.format(f));
            analysis.setTratio(t);
            List<Analysis> a=analysisService.getByCon(lastDate,lastDate,String.valueOf(analysis.getRegion()),analysis.getProduct());
            if(a.size()!=0&&!a.equals("")){
                double b=((float)analysis.getPerson()-(float)(a.get(0).getPerson()))/(float)(a.get(0).getPerson())*100;
                float dd=Float.parseFloat(fnum.format(b));
                analysis.setHratio(dd);
          }else{
              float m = rand.nextInt(41)-20+rand.nextFloat();
              float n=Float.parseFloat(fnum.format(m));
              analysis.setHratio(n);
            }
            analysisService.insert(analysis);
        }catch (ParseException e) {
            e.printStackTrace();

        }

        JSONResult result=new JSONResult().ok("success");
            return result;

    }

    @PostMapping(value = "update")
    public JSONResult update(@RequestBody Analysis analysis){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String d=analysis.getDate();
            long dif = df.parse(d).getTime()-86400*1000;//减一天
            Date date=new Date();
            date.setTime(dif);
            String lastDate=df.format(date);
            List<Analysis> a=analysisService.getByCon(lastDate,lastDate,String.valueOf(analysis.getRegion()),analysis.getProduct());
            if(a.size()!=0&&!a.equals("")){
                double b=((float)analysis.getPerson()-(float)(a.get(0).getPerson()))/(float)(a.get(0).getPerson())*100;
                DecimalFormat fnum  =   new  DecimalFormat("##0.00");
                float dd=Float.parseFloat(fnum.format(b));
                analysis.setHratio(dd);
            }
          analysisService.update(analysis);
        }catch (ParseException e) {
            e.printStackTrace();

        }
        JSONResult result=new JSONResult().ok("success");
        return result;
    }

    @RequestMapping(value = "delete")
    public JSONResult delete( @RequestParam(value = "id") int id){
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
