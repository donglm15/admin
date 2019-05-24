package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.PageProduce;
import com.unicom.admin.service.PageProduceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pageProduce")
public class PageProduceController {

    @Autowired
    private PageProduceService pageProduceService;

    //http://localhost:8080/pageProduceService/list
    @ApiOperation(value="获取产品列表")
    @RequestMapping(value="list")
    public JSONResult getAllPageProduce(){
        List<PageProduce> list=pageProduceService.getAllPageProduce();

        return new JSONResult().ok(list);
    }

    //新增功能（get)
    @RequestMapping(value = "save")
    @ApiOperation(value = "插入新的产品数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="produce_datatime",value="产品的插入日期",required = true,dataType = "string"),
            @ApiImplicitParam(name="produce_name",value="产品的插入名称",required = true,dataType = "string")
    })
    public JSONResult insert(
            @RequestParam(name="produce_id") int produce_id,
            @RequestParam(name="produce_datatime") String produce_datatime,
            @RequestParam(name="produce_type") String produce_type,
            @RequestParam(name="produce_name") String produce_name,
            @RequestParam(name="produce_team_name") String produce_team_name,
            @RequestParam(name="produce_importance") int produce_importance,
            @RequestParam(name="produce_details") String produce_details
    ){
        pageProduceService.insert(produce_id,produce_datatime,produce_type,produce_name,produce_team_name,produce_importance,produce_details);
        return new JSONResult().ok("success");
    }

    @RequestMapping(value = "getPageProduce/{produce_id}")
    public JSONResult getPageProduceById(
            @PathVariable(name = "produce_id") int produce_id
    ){
        PageProduce pageProduce=pageProduceService.getPageProduceById(produce_id);
        return new JSONResult().ok(pageProduce);
    }

    @PostMapping(value = "saveOne")
    public JSONResult saveOne(@RequestBody PageProduce pageProduce){
        pageProduceService.insert(pageProduce);
        return new JSONResult().ok("success");
    }

    //分页查询
    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "20") int limit,
            @RequestParam(value = "produce_id",defaultValue = "") int produce_id,
            @RequestParam(value = "produce_datatime",defaultValue = "") String produce_datatime,
            @RequestParam(name = "produce_type",defaultValue = "") String produce_type,
            @RequestParam(name = "produce_name",defaultValue = "") String produce_name,
            @RequestParam(name = "produce_team_name",defaultValue = "") String produce_team_name,
            @RequestParam(name = "produce_importance",defaultValue = "") int produce_importance,
            @RequestParam(name = "produce_details",defaultValue = "") String produce_details,
            @RequestParam(name = "sort",defaultValue = "+id") String order
    ){
        PageHelper.startPage(page,limit);

        List<PageProduce> list=pageProduceService.getPageProduceByCon(produce_name,produce_importance,produce_type,order);

        PageInfo<PageProduce> pageInfo =new PageInfo<>(list);

        return new JSONResult().ok(pageInfo);
    }

//    @RequestMapping(value = "trans")
//    public void insertNews(@RequestBody PageProduce news){
//        pageProduceService.insertPageProduce(pageProduce);
//    }
}
