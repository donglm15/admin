package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Member {
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date date;
    private String title;
    private String content;
    private String author;
    private String readings;
    private MemberType memberType;
    private String membertypeid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReadings() {
        return readings;
    }

    public void setReadings(String readings) {
        this.readings = readings;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

//    public int getMembertypeid() {
//        return membertypeid;
//    }
//
//    public void setMembertypeid(int membertypeid) {
//        this.membertypeid = membertypeid;
//    }


    public String getMembertypeid() {
        return membertypeid;
    }

    public void setMembertypeid(String membertypeid) {
        this.membertypeid = membertypeid;
    }

    public Member(String membertypeid) {
        this.membertypeid = membertypeid;
    }

    public Member() {
    }

    public Member(int id, Date date, String title, String content, String author, String readings , MemberType memberType) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.author = author;
        this.readings = readings;
        this.memberType = memberType;
    }
}
