package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Notice {
    private int noticeId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date noticeDate;

    private String noticePublish;

    private String noticeTitle;

    private String noticeContent;

    private int noticeReadNum;

    private String noticeStatus;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticePublish() {
        return noticePublish;
    }

    public void setNoticePublish(String noticePublish) {
        this.noticePublish = noticePublish == null ? null : noticePublish.trim();
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public int getNoticeReadNum() {
        return noticeReadNum;
    }

    public void setNoticeReadNum(int noticeReadNum) {
        this.noticeReadNum = noticeReadNum;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus == null ? null : noticeStatus.trim();
    }
}