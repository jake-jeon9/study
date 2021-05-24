package com.example.practice7.model;

import java.io.Serializable;

public class Member implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String addr;

    public Member() {
    }

    public Member(String name, String email, String phone, String addr) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
