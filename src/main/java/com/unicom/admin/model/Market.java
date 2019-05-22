package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Market {
    private int id;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date endDate;

    private String employName;

    private int importance;

    private String jobPlace;

    private String content;

    private String reviewer;

    private MarketType marketType;

    private MarketStatus marketStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName == null ? null : employName.trim();
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace == null ? null : jobPlace.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public MarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    public MarketStatus getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(MarketStatus marketStatus) {
        this.marketStatus = marketStatus;
    }


    public Market() {
    }

    public Market(int id, String title, Date endDate, String employName, int importance, String jobPlace, String content, String reviewer, MarketType marketType,MarketStatus marketStatus) {
        this.id = id;
        this.title = title;
        this.endDate = endDate;
        this.employName = employName;
        this.importance = importance;
        this.jobPlace = jobPlace;
        this.content = content;
        this.reviewer = reviewer;
        this.marketType = marketType;
        this.marketStatus = marketStatus;
    }

}