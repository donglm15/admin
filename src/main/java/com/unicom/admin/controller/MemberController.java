package com.unicom.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.admin.model.JSONResult;
import com.unicom.admin.model.Member;
import com.unicom.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping(value = "member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "list")
    public JSONResult getAllMember(){
        List<Member> list=memberService.getAllMember();

        return new JSONResult().ok(list);
    }

    @RequestMapping(value = "save")
    public JSONResult insert(
            @RequestParam(name="date") String date,
            @RequestParam(name="membertypeid") int membertypeid,
            @RequestParam(name="title") String title,
            @RequestParam(name="content") String content,
            @RequestParam(name="author") String author,
            @RequestParam(name="readings") int readings
    ){
        memberService.insert(date,membertypeid,title,content,author,readings);

        return new JSONResult().ok("success");
    }

    @RequestMapping(value = "getMember/{id}")
    public JSONResult getMemberById(
            @PathVariable(name = "id") int id
    ){
       Member member= (Member) memberService.getMemberById(id);
       return new JSONResult().ok(member);
    }

    @PostMapping(value = "saveOne")
    public JSONResult saveOne(@RequestBody Member member){
                memberService.insert(member);
                return new JSONResult().ok("success");
    }

    @GetMapping(value = "select")
    public JSONResult select(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit,
            @RequestParam(name = "title",defaultValue = "") String title,
            @RequestParam(name = "type",defaultValue = "") String type,
            @RequestParam(name = "sort",defaultValue = "-id") String sort
    ){
        PageHelper.startPage(page,limit);
        List<Member> list=memberService.getMemeberByCon(title,type,sort);
        PageInfo<Member> pageInfo =new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);

    }
    @RequestMapping(value = "delete/{id}")
    public JSONResult deleteMemberById(@PathVariable(name = "id")int id){
                memberService.deleteMemberById(id);
                return new JSONResult().ok("success");
    }

//    @RequestMapping(value = "trans")
//    public void insertMember(@RequestBody Member member){
//                memberService.insertMember(member);
//    }


    @PostMapping(value = "update")
    public JSONResult updateMember(@RequestBody Member member){
        memberService.updateMember(member);
        return new JSONResult().ok("success");
    }

    @PostMapping(value = "insert")
    public JSONResult insertMemebr(@RequestBody Member member){
        memberService.insert(member);
    return new JSONResult().ok("success");
    }
}
