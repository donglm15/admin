package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Notice;
import com.unicom.admin.model.PageProduce;
import com.unicom.admin.service.PageProduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pageProduce")
@Api(tags = "联通之家-产品管理模块")
public class PageProduceController {

    @Autowired
    private PageProduceService pageProduceService;

//    http://localhost:8080/pageProduceService/list
    @RequestMapping(value="list")
    @ApiOperation(value="获取产品列表")
    public JSONResult getAll(){
        List<PageProduce> list=pageProduceService.getAll();

        return new JSONResult().ok(list);
    }

    //分页查询
    @GetMapping(value = "lost")
    @ApiOperation(value = "后台分页获取产品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页码", required = true,dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页显示条数", required = true,dataType = "int"),
            @ApiImplicitParam(name = "produce_name", value = "产品名称",dataType = "string"),
            @ApiImplicitParam(name = "produce_importance", value = "重要性",dataType = "int"),
            @ApiImplicitParam(name = "produce_type", value = "产品类型",dataType = "string"),
            @ApiImplicitParam(name = "order", value = "排序方式",dataType = "string")
    })
    public JSONResult select(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "20") int limit,
            @RequestParam(name = "produce_name",defaultValue = "") String produce_name,
            @RequestParam(name = "produce_importance",defaultValue = "") int produce_importance,
            @RequestParam(name = "produce_type",defaultValue = "") String produce_type,
            @RequestParam(name = "sort",defaultValue = "+id") String order
    ){
        PageHelper.startPage(page,limit);

        List<PageProduce> list=pageProduceService.getAllPageProduce(produce_name,produce_importance,produce_type,order);

        PageInfo<PageProduce> pageInfo =new PageInfo<>(list);

        return new JSONResult().ok(pageInfo);
    }



    //增
    @PostMapping(value = "insert")
    @ApiOperation(value = "插入新建产品")
    @ApiImplicitParam(name = "pageProduce", value = "新建产品内容", required = true, dataType = "PageProduce")
    public JSONResult insertPageProduce(@RequestBody PageProduce pageProduce){
        pageProduceService.insertPageProduce(pageProduce);
        return new JSONResult().ok("success");
    }

    //删
    @GetMapping(value = "delete")
    @ApiOperation(value = "根据产品编号删除产品")
    @ApiImplicitParam(name = "produce_id",value = "产品编号",required = true,dataType = "int")
    public JSONResult deleteNotice(@RequestParam(name = "produce_id") int produce_id){
        pageProduceService.deletePageProduce(produce_id);
        return new JSONResult().ok("success");
    }

    //获取产品详情
    @GetMapping(value = "getOnePageProduce")
    @ApiOperation(value = "根据产品编号获取公告详情")
    @ApiImplicitParam(name = "produce_id",value = "公告编号",required = true,dataType = "int")
    public JSONResult getOnePageProduce(@RequestParam(name = "produce_id") int produce_id){
        PageProduce notice=pageProduceService.getOnePageProduce(produce_id);
        return new JSONResult().ok(notice);
    }

    //更新产品信息
    @PostMapping(value = "update")
    @ApiOperation(value = "更新产品信息")
    @ApiImplicitParam(name = "pageProduce", value = "更新产品内容", required = true, dataType = "PageProduce")
    public JSONResult updatePageProduce(@RequestBody PageProduce pageProduce){
        pageProduceService.updatePageProduce(pageProduce);
        return new JSONResult().ok("success");
    }



}
