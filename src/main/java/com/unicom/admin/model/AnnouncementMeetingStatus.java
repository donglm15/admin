package com.unicom.admin.model;

public class AnnouncementMeetingStatus {
    private int id;

    private String meetingStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus == null ? null : meetingStatus.trim();
    }

    public AnnouncementMeetingStatus() {
    }

    public AnnouncementMeetingStatus(int id, String meetingStatus) {
        this.id = id;
        this.meetingStatus = meetingStatus;
    }
}