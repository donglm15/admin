package com.unicom.admin.model;

public class InfoType {
    private int id;

    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public InfoType() {
    }

    public InfoType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }
}