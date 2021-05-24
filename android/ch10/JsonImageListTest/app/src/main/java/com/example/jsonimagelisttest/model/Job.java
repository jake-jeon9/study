package com.example.jsonimagelisttest.model;

import java.io.Serializable;

public class Job implements Serializable {
    private int num;
    private String job;
    private String content;
    private String img;

    public Job() {
    }

    public Job(int num, String job, String content, String img) {
        this.num = num;
        this.job = job;
        this.content = content;
        this.img = img;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}