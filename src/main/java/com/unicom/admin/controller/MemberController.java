package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Member;
import com.unicom.admin.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping(value = "member")
@Api(tags = "联通之家-党员管理模块")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "获取当前页信息表")
    @GetMapping(value = "list")
    public JSONResult getAllMember(){
        List<Member> list=memberService.getAllMember();

        return new JSONResult().ok(list);
    }

//    @RequestMapping(value = "save")
//    public JSONResult insert(
//            @RequestParam(name="date") String date,
//            @RequestParam(name="membertypeid") int membertypeid,
//            @RequestParam(name="title") String title,
//            @RequestParam(name="content") String content,
//            @RequestParam(name="author") String author,
//            @RequestParam(name="readings") int readings
//    ){
//        memberService.insert(date,membertypeid,title,content,author,readings);
//
//        return new JSONResult().ok("success");
//    }

//    @RequestMapping(value = "getMember/{id}")
//    public JSONResult getMemberById(
//            @PathVariable(name = "id") int id
//    ){
//       Member member= (Member) memberService.getMemberById(id);
//       return new JSONResult().ok(member);
//    }
//
//    @PostMapping(value = "saveOne")
//    public JSONResult saveOne(@RequestBody Member member){
//                memberService.insert(member);
//                return new JSONResult().ok("success");
//    }

    @GetMapping(value = "select")
    @ApiOperation(value = "后台分页获取信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "分页页码",required = true,dataType ="int"),
            @ApiImplicitParam(name = "limit",value = "每页条数",required = true,dataType = "int"),
            @ApiImplicitParam(name = "title",value = "按活动名称搜索关键字",required = true,dataType = "string"),
            @ApiImplicitParam(name = "type",value = "活动类别",required = true,dataType = "string"),
            @ApiImplicitParam(name = "sort",value = "排序",required = true,dataType = "string")
    })
    public JSONResult select(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit,
            @RequestParam(name = "title",defaultValue = "") String title,
            @RequestParam(name = "type",defaultValue = "") String type,
            @RequestParam(name = "sort",defaultValue = "+id") String sort
    ){
        PageHelper.startPage(page,limit);
        List<Member> list=memberService.getMemeberByCon(title,type,sort);
        PageInfo<Member> pageInfo =new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);

    }
    @GetMapping(value = "delete/{id}")
    @ApiOperation(value = "根据活动id删除活动")
    public JSONResult deleteMemberById(@PathVariable(name = "id")int id){
                memberService.deleteMemberById(id);
                return new JSONResult().ok("success");
    }

//    @RequestMapping(value = "trans")
//    public void insertMember(@RequestBody Member member){
//                memberService.insertMember(member);
//    }


    @PostMapping(value = "update")
    @ApiOperation(value = "更新活动")
    public JSONResult updateMember(@RequestBody Member member){
        memberService.updateMember(member);
        return new JSONResult().ok("success");
    }


    @PostMapping(value = "updatetype")
    @ApiOperation(value = "更新类型")
    public JSONResult update(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "typename") String typename
    ){
        memberService.update(id,typename);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "insert")
    @ApiOperation(value = "插入新建活动")
    public JSONResult insertMemebr(@RequestBody Member member){
        memberService.insert(member);
    return new JSONResult().ok("success");
    }
}
