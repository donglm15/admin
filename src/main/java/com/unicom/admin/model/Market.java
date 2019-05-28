package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Market {
    private int id;

    private String title;

//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date endDate;

    private String employName;

    private int importance;

    private String jobPlace;

    private String content;

    private String reviewer;

    private MarketType marketType;

    private MarketStatus marketStatus;

    private String salary;

    private String education;

    private String experience;

    private String recruitment;

    private String welfare;

    private String company;

    private String urlImg;

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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Market() {
    }

    public Market(int id, String title, Date endDate, String employName, int importance, String jobPlace, String content, String reviewer,
                  MarketType marketType,MarketStatus marketStatus,String salary,String education,
                   String experience,String recruitment,String welfare,String company,String urlImg
    ) {
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
        this.salary = salary;
        this.education = education;
        this.experience = experience;
        this.recruitment = recruitment;
        this.welfare = welfare;
        this.company = company;
        this.urlImg=urlImg;
    }

}