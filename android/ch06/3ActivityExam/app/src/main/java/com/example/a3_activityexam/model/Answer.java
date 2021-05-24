package com.example.a3_activityexam.model;

import java.io.Serializable;

public class Answer implements Serializable {

    private String id;
    private String pw;
    private String email;

    public Answer() {

    }

    public Answer(String id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
