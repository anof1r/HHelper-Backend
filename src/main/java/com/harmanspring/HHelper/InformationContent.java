package com.harmanspring.HHelper;


public class InformationContent {

    private String literature;
    private String schedule;
    private String links;
    private int imgId;

    InformationContent() {
    }

    public void addLiterature(String schedule) {
        this.schedule = schedule;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getLinks() {
        return links;
    }

    public String getLiterature() {
        return literature;
    }

    public String getSchedule() {
        return schedule;
    }
}