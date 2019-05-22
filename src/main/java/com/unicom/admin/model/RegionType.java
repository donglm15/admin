package com.unicom.admin.model;

public class RegionType {
    private int id;
    private String cityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public RegionType() {
    }

    public RegionType(int id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }
}
