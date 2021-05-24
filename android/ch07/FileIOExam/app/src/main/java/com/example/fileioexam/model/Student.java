package com.example.fileioexam.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String addr;

    public Student(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
