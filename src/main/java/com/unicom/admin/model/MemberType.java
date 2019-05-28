package com.unicom.admin.model;

public class MemberType {
    private int id;
    private String typename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public MemberType() {
    }

    public MemberType(int id, String typename) {
        this.id = id;
        this.typename = typename;
    }
}