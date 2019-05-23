package com.unicom.admin.model;

public class MemberType {
    private int id;

    private String typename;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typename;
    }
    public void setTypeName(String typename){
        this.typename=typename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public  MemberType(String type){
        this.type=type;
    }
    public MemberType(){

    }
    public MemberType(int id,String typename){
        this.id = id;
        this.typename = typename;
        this.type=type;
    }
}