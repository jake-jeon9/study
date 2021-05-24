package com.example.a3_listadapterexam.model;

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

    public void setJob(String title) {
        this.job = title;
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
