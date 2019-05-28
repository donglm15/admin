package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Market;
import com.unicom.admin.service.MarketService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "market")
public class MarketController {
    //前端查询表
    @Autowired
    private MarketService marketService;
    @ApiOperation(value = "岗位信息列表")
    @GetMapping(value = "list")
    public JSONResult getAllMarket(){
        List<Market> list = marketService.getAllMarket();
        return  new JSONResult().ok(list);
    }
    //后端分页get方法
    @ApiOperation(value = "岗位信息分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name="page",value = "分页页码",required = true,dataType = "int"),
        @ApiImplicitParam(name="limit",value = "单页条数",required = true,dataType = "int"),
        @ApiImplicitParam(name="title",value = "岗位名称",dataType = "String"),
        @ApiImplicitParam(name="importance",value = "优先级",dataType = "String"),
        @ApiImplicitParam(name="marketType",value = "岗位序列",dataType = "String"),
        @ApiImplicitParam(name="sort",value = "排序",dataType = "String"),
    })
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
    //新增
    @ApiOperation(value = "新增岗位")
    @PostMapping(value = "create")
    public JSONResult create(@RequestBody Market market){
        marketService.insert(market);
        return new JSONResult().ok("success");
    }
    //查看 后端传值的两种方法
  //  @GetMapping(value = "show") postman测接口方法show 参数  show/{id}=show/3
   // public JSONResult getMarketById(@RequestParam(value="id") int id){
    @ApiOperation(value = "查看岗位")
    @GetMapping(value = "show/{id}")
    public JSONResult getMarketById(@PathVariable(name="id") int id){
        Market market = marketService.getMarketById(id);
        return  new JSONResult().ok(market);
    }
    //编辑
    @ApiOperation(value = "编辑岗位")
//    ) throws Exception{
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        marketService.updateMarket(
//                id,title,sdf.parse(endDate),marketType,employName,jobPlace,marketStatus,importance,content
    @PostMapping(value = "update")
    public JSONResult update(@RequestBody Market market){
        marketService.updateMarket(market);
        return new JSONResult().ok("success");
    }

    //删除
    @ApiOperation(value = "删除岗位")
    @DeleteMapping(value = "delete/{id}")
    public JSONResult delete(@PathVariable(name="id") int id){
        marketService.delete(id);
        return new JSONResult().ok("success");
    }
}
