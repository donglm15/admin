package com.unicom.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Info {
    private int id;

    private String imgUrl;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date date;

    private InfoType infoType;

    private Short read;

    private Short like;

    private Short favorite;

    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public InfoType getInfoType() {
        return infoType;
    }

    public void setInfoType(InfoType infoType) {
        this.infoType = infoType;
    }

    public Short getRead() {
        return read;
    }

    public void setRead(Short read) {
        this.read = read;
    }

    public Short getLike() {
        return like;
    }

    public void setLike(Short like) {
        this.like = like;
    }

    public Short getFavorite() {
        return favorite;
    }

    public void setFavorite(Short favorite) {
        this.favorite = favorite;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Info() {
    }

    public Info(int id, String imgUrl, String title, Date date, InfoType infoType, Short read, Short like, Short favorite, String content) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
        this.date = date;
        this.infoType = infoType;
        this.read = read;
        this.like = like;
        this.favorite = favorite;
        this.content = content;
    }
}