package com.example.a3_databaseexam;

import java.io.Serializable;

public class Student implements Serializable {
    private  int num;
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int tot;
    private float avg;

    public Student(int num, String name, int kor, int eng, int mat, int tot, float avg) {
        this.num = num;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.tot = tot;
        this.avg = avg;
    }

    public Student() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
