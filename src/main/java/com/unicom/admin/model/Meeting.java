package com.unicom.admin.model;

public class Meeting {
    private int id;

    private String meetingName;

    private String meetingPosition;

    private int peopleNum;

    private int ifMoreid;

    private int ifOpenid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName == null ? null : meetingName.trim();
    }

    public String getMeetingPosition() {
        return meetingPosition;
    }

    public void setMeetingPosition(String meetingPosition) {
        this.meetingPosition = meetingPosition == null ? null : meetingPosition.trim();
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public int getIfMoreid() {
        return ifMoreid;
    }

    public void setIfMoreid(int ifMoreid) {
        this.ifMoreid = ifMoreid;
    }

    public int getIfOpenid() {
        return ifOpenid;
    }

    public void setIfOpenid(int ifOpenid) {
        this.ifOpenid = ifOpenid;
    }

    public Meeting() {
    }

    public Meeting(int id, String meetingName, String meetingPosition, int peopleNum, int ifMoreid, int ifOpenid) {
        this.id = id;
        this.meetingName = meetingName;
        this.meetingPosition = meetingPosition;
        this.peopleNum = peopleNum;
        this.ifMoreid = ifMoreid;
        this.ifOpenid = ifOpenid;
    }
}