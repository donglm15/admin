package com.unicom.admin.model;

/*
* 需求描述：用户管理，职位类别实体类
* author:liufeng
* time:2019.05.21 14:37
* */

public class position {
    private int id;

    private String positionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public position() {
    }

    public position(int id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }
}