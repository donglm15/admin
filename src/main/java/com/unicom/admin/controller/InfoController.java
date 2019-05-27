package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.Info;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.service.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "info")
@Api(tags = "联通之家-资讯管理模块")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping(value = "allInfo")
    @ApiOperation(value = "获取所有资讯列表")
    public JSONResult getAllInfo(){
        List<Info> list = infoService.getAllInfo();
        return new JSONResult().ok(list);
    }

    @GetMapping(value = "topInfo")
    @ApiOperation(value = "获取浏览量最高得5条资讯列表")
    public JSONResult getTopInfo(){
        List<Info> list = infoService.getTopInfo();
        return new JSONResult().ok(list);
    }

    @GetMapping(value = "list")
    @ApiOperation(value = "后台分页获取资讯列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "分页页码",required = true,dataType = "int"),
            @ApiImplicitParam(name = "limit",value = "每页显示条数",required = true,dataType = "int"),
            @ApiImplicitParam(name = "title",value = "通过资讯标题关键词搜索资讯",dataType = "String"),
            @ApiImplicitParam(name = "type",value = "资讯类别",dataType = "String")
    })
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

    @GetMapping(value = "updateByEdit")
    @ApiOperation(value = "保存编辑资讯")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "待编辑的id",required = true,dataType = "int"),
            @ApiImplicitParam(name = "title",value = "资讯标题",required = true,dataType = "String"),
            @ApiImplicitParam(name = "content",value = "资讯正文",required = true,dataType = "String"),
            @ApiImplicitParam(name = "infoTypeId",value = "资讯类别",required = true,dataType = "int")
    })
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

    @GetMapping(value = "delete")
    @ApiOperation(value = "删除一条资讯")
    @ApiImplicitParam(name = "id",value = "待删除的id",required = true,dataType = "int")
    public JSONResult delete(
            @RequestParam(name = "id") int id
    ){
                infoService.deleteInfoByd(id);
                return new JSONResult().ok("success");
    }

    @GetMapping(value = "infoDetail/{id}")
    @ApiOperation(value = "获取一条资讯详情")
    @ApiImplicitParam(name = "id",value = "待查看的id",required = true,dataType = "int")
    public JSONResult getInfoById(@PathVariable(name = "id") int id){
         Info info = infoService.getInfoById(id);
         return new JSONResult().ok(info);
    }

    @GetMapping(value = "updateRead")
    @ApiOperation(value = "更新已浏览的id的浏览量")
    @ApiImplicitParam(name = "id",value = "已浏览的id",required = true,dataType = "int")
    public JSONResult updateRead(
            @RequestParam(name = "id") int id
    ){
        infoService.updateRead(id);
        return new JSONResult().ok("success");
    }

    @GetMapping(value = "updateLikeFavo")
    @ApiOperation(value = "更新点赞收藏的资讯id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "待操作的id",required = true,dataType = "int"),
            @ApiImplicitParam(name = "likeFlag",value = "是否为点赞",required = true,dataType = "boolean"),
            @ApiImplicitParam(name = "flag",value = "是否为加",required = true,dataType = "boolean")
    })
    public JSONResult updateLikeFavo(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "likeFlag") boolean likeFlag,
            @RequestParam(name = "flag") boolean flag
    ){
        infoService.updateLikeFavo(id,likeFlag,flag);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "insert")
    @ApiOperation(value = "添加新建的资讯")
    @ApiImplicitParam(name = "info",value = "新建的资讯",required = true,dataType = "Info")
    public JSONResult insert(@RequestBody Info info){
                infoService.insert(info);
                return new JSONResult().ok("success");
    }
}
