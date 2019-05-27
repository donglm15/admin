package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Announcement {
    private int id;

    private String meetingID;

    private String meetingTheme;

    private String department;
    //格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",locale = "zh",timezone = "GMT+8")

    private Date meetingDate;

    private int meetingStatusid;

    private AnnouncementMeetingStatus announcementMeetingStatus;

    public AnnouncementMeetingStatus getAnnouncementMeetingStatus() {
        return announcementMeetingStatus;
    }

    public void setAnnouncementMeetingStatus(AnnouncementMeetingStatus announcementMeetingStatus) {
        this.announcementMeetingStatus = announcementMeetingStatus;
    }

    private String meetingPosition;

    private Date delayDate;

    private String meetingType;

    private String user;

    private String meetingPeople;

    private int dateLong;

    private String presenter;

    private String data;

    private String meetingContent;

    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID == null ? null : meetingID.trim();
    }

    public String getMeetingTheme() {
        return meetingTheme;
    }

    public void setMeetingTheme(String meetingTheme) {
        this.meetingTheme = meetingTheme == null ? null : meetingTheme.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public int getMeetingStatusid() {
        return meetingStatusid;
    }

    public void setMeetingStatusid(int meetingStatusid) {
        this.meetingStatusid = meetingStatusid;
    }

    public String getMeetingPosition() {
        return meetingPosition;
    }

    public void setMeetingPosition(String meetingPosition) {
        this.meetingPosition = meetingPosition == null ? null : meetingPosition.trim();
    }

    public Date getDelayDate() {
        return delayDate;
    }

    public void setDelayDate(Date delayDate) {
        this.delayDate = delayDate;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType == null ? null : meetingType.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getMeetingPeople() {
        return meetingPeople;
    }

    public void setMeetingPeople(String meetingPeople) {
        this.meetingPeople = meetingPeople == null ? null : meetingPeople.trim();
    }

    public int getDateLong() {
        return dateLong;
    }

    public void setDateLong(int dateLong) {
        this.dateLong = dateLong;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter == null ? null : presenter.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getMeetingContent() {
        return meetingContent;
    }

    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent == null ? null : meetingContent.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Announcement() {
    }

    public Announcement(int id, String meetingID, String meetingTheme, String department, Date meetingDate, int meetingStatusid, AnnouncementMeetingStatus announcementMeetingStatus, String meetingPosition, Date delayDate, String meetingType, String user, String meetingPeople, int dateLong, String presenter, String data, String meetingContent, String msg) {
        this.id = id;
        this.meetingID = meetingID;
        this.meetingTheme = meetingTheme;
        this.department = department;
        this.meetingDate = meetingDate;
        this.meetingStatusid = meetingStatusid;
        this.announcementMeetingStatus = announcementMeetingStatus;
        this.meetingPosition = meetingPosition;
        this.delayDate = delayDate;
        this.meetingType = meetingType;
        this.user = user;
        this.meetingPeople = meetingPeople;
        this.dateLong = dateLong;
        this.presenter = presenter;
        this.data = data;
        this.meetingContent = meetingContent;
        this.msg = msg;
    }
}