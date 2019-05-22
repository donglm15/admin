package com.unicom.admin.model;

public class Analysis {
    private int id;

    private String product;

    private String date;

    private int region;

    private RegionType regionType;

    private int person;

    private float billing;

    private float tratio;

    private float hratio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public float getBilling() {
        return billing;
    }

    public void setBilling(float billing) {
        this.billing = billing;
    }

    public float getTratio() {
        return tratio;
    }

    public void setTratio(float tratio) {
        this.tratio = tratio;
    }

    public float getHratio() {
        return hratio;
    }

    public void setHratio(float hratio) {
        this.hratio = hratio;
    }

    public Analysis() {
    }

    public Analysis(int id, String product, String date, int region, RegionType regionType, int person, float billing, float tratio, float hratio) {
        this.id = id;
        this.product = product;
        this.date = date;
        this.region = region;
        this.regionType = regionType;
        this.person = person;
        this.billing = billing;
        this.tratio = tratio;
        this.hratio = hratio;
    }
}