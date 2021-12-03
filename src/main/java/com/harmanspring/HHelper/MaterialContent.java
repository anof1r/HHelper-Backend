package com.harmanspring.HHelper;


public class MaterialContent {
    private int id;
    private String imgId;
    private String date;
    private String title;
    private String content;
    private String homeWork;

    MaterialContent() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageId(String imageId) {
        this.imgId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getImageId() {
        return imgId;
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
