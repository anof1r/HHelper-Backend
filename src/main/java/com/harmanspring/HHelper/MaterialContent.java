package com.harmanspring.HHelper;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class MaterialContent {
    private int id;
    private int imageId;
    private String date;
    private String title;
    private String content;
    private String homeWork;

    MaterialContent() {
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
