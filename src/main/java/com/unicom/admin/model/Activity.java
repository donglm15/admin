package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Activity {
    private int id;

    private ActivityType activityType;

    private int people;

    private String tag;

    private String prize;

    private String title;

    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",locale = "zh",timezone = "GTM+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",locale = "zh",timezone = "GTM+8")
    private Date endTime;

    private String uid;

    private String master;

    private String content;

    private String message;

    private String other;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize == null ? null : prize.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Activity() {
    }

    public Activity(int id, ActivityType activityType, int people, String tag, String prize, String title, String address, Date startTime, Date endTime, String uid, String master, String content, String message, String other) {
        this.id = id;
        this.activityType = activityType;
        this.people = people;
        this.tag = tag;
        this.prize = prize;
        this.title = title;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
        this.master = master;
        this.content = content;
        this.message = message;
        this.other = other;
    }
}