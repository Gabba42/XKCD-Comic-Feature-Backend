package com.glisboa.slackfeature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic {

    private long num;
    private String year;
    private String title;
    private String alt;
    private String img;

    public Comic() {
    }

    public Comic(long num, String year, String title, String alt, String img) {
        this.num = num;
        this.year = year;
        this.title = title;
        this.alt = alt;
        this.img = img;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "num=" + num +
                ", year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", alt='" + alt + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}