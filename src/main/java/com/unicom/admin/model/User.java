package com.unicom.admin.model;

/*
* 需求描述：用户管理，用户信息实体类
* author:liufeng
* time:2019.05.21 14:41
* */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {
    private int id;

    private String account;

    private String userName;

    @JsonProperty("Organization")
    private String Organization;

    private position position;

    private String employeeNumber;

    private String phone;
    //格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date lastLoginTime;

    private String profileAddress;

    private String introduction;

    private String speciality;

    private String activity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @JsonProperty("Organization")
    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        this.Organization = organization == null ? null : organization.trim();
    }

    public position getPosition() {
        return position;
    }

    public void setPosition(position position) {
        this.position = position;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber == null ? null : employeeNumber.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getProfileAddress() {
        return profileAddress;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress == null ? null : profileAddress.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public User() {
    }

    public User(int id, String account, String userName, String organization, position positionType, String employeeNumber, String phone, Date lastLoginTime, String profileAddress, String introduction, String speciality, String activity) {
        this.id = id;
        this.account = account;
        this.userName = userName;
        this.Organization = organization;
        this.position = positionType;
        this.employeeNumber = employeeNumber;
        this.phone = phone;
        this.lastLoginTime = lastLoginTime;
        this.profileAddress = profileAddress;
        this.introduction = introduction;
        this.speciality = speciality;
        this.activity = activity;
    }
}