package com.example.practice1.model;

import java.io.Serializable;

public class Job implements Serializable {

    private String job;
    private String description;
    private int image;

    public Job() {
    }

    public Job(String job, String description, int image) {
        this.job = job;
        this.description = description;
        this.image = image;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
