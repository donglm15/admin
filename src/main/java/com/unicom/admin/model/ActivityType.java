package com.unicom.admin.model;

public class ActivityType {
    private int id;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public ActivityType() {
    }

    public ActivityType(int id, String type) {
        this.id = id;
        this.type = type;
    }
}