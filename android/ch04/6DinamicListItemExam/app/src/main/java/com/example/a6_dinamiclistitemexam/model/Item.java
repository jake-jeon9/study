package com.example.a6_dinamiclistitemexam.model;

public class Item {
    private String name;
    private int num;

    public Item() {

    }

    public Item(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
