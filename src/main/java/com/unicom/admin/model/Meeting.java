package com.unicom.admin.model;

public class Meeting {
    private int id;

    private String meetingName;

    private String meetingPosition;

    private int peopleNum;

    private int ifMore;

    private int ifOpen;

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

    public int getIfMore() {
        return ifMore;
    }

    public void setIfMore(int ifMore) {
        this.ifMore = ifMore;
    }

    public int getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(int ifOpen) {
        this.ifOpen = ifOpen;
    }

    public Meeting() {
    }

    public Meeting(int id, String meetingName, String meetingPosition, int peopleNum, int ifMore, int ifOpen) {
        this.id = id;
        this.meetingName = meetingName;
        this.meetingPosition = meetingPosition;
        this.peopleNum = peopleNum;
        this.ifMore = ifMore;
        this.ifOpen = ifOpen;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", meetingName='" + meetingName + '\'' +
                ", meetingPosition='" + meetingPosition + '\'' +
                ", peopleNum=" + peopleNum +
                ", ifMore=" + ifMore +
                ", ifOpen=" + ifOpen +
                '}';
    }
}