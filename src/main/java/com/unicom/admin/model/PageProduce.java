package com.unicom.admin.model;

import java.util.Date;

public class PageProduce {
    private int produce_id;

    private Date produce_datatime;

    private String produce_type;

    private String produce_name;

    private String produce_team_name;

    private int produce_importance;

    private String produce_details;

    public int getProduce_id() {
        return produce_id;
    }

    public void setProduce_id(int produce_id) {
        this.produce_id = produce_id;
    }

    public Date getProduce_datatime() {
        return produce_datatime;
    }

    public void setProduce_datatime(Date produce_datatime) {
        this.produce_datatime = produce_datatime;
    }

    public String getProduce_type() {
        return produce_type;
    }

    public void setProduce_type(String produce_type) {
        this.produce_type = produce_type == null ? null : produce_type.trim();
    }

    public String getProduce_name() {
        return produce_name;
    }

    public void setProduce_name(String produce_name) {
        this.produce_name = produce_name == null ? null : produce_name.trim();
    }

    public String getProduce_team_name() {
        return produce_team_name;
    }

    public void setProduce_team_name(String produce_team_name) {
        this.produce_team_name = produce_team_name == null ? null : produce_team_name.trim();
    }

    public int getProduce_importance() {
        return produce_importance;
    }

    public void setProduce_importance(int produce_importance) {
        this.produce_importance = produce_importance;
    }

    public String getProduce_details() {
        return produce_details;
    }

    public void setProduce_details(String produce_details) {
        this.produce_details = produce_details == null ? null : produce_details.trim();
    }
}