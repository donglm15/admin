package com.unicom.admin.model;

public class Market {
    private tinyint id;

    private varchar title;

    private datetime startDate;

    private datetime endDate;

    private varchar employName;

    private tinyint importance;

    private varchar jobPlace;

    private varchar content;

    private tinyint marketTypeId;

    private tinyint statusId;

    public tinyint getId() {
        return id;
    }

    public void setId(tinyint id) {
        this.id = id;
    }

    public varchar getTitle() {
        return title;
    }

    public void setTitle(varchar title) {
        this.title = title;
    }

    public datetime getStartDate() {
        return startDate;
    }

    public void setStartDate(datetime startDate) {
        this.startDate = startDate;
    }

    public datetime getEndDate() {
        return endDate;
    }

    public void setEndDate(datetime endDate) {
        this.endDate = endDate;
    }

    public varchar getEmployName() {
        return employName;
    }

    public void setEmployName(varchar employName) {
        this.employName = employName;
    }

    public tinyint getImportance() {
        return importance;
    }

    public void setImportance(tinyint importance) {
        this.importance = importance;
    }

    public varchar getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(varchar jobPlace) {
        this.jobPlace = jobPlace;
    }

    public varchar getContent() {
        return content;
    }

    public void setContent(varchar content) {
        this.content = content;
    }

    public tinyint getMarketTypeId() {
        return marketTypeId;
    }

    public void setMarketTypeId(tinyint marketTypeId) {
        this.marketTypeId = marketTypeId;
    }

    public tinyint getStatusId() {
        return statusId;
    }

    public void setStatusId(tinyint statusId) {
        this.statusId = statusId;
    }
}