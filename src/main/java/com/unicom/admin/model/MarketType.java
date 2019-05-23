package com.unicom.admin.model;

public class MarketType {
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
        this.typeName = typeName;
    }

    public MarketType() {
    }

    public MarketType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }
}