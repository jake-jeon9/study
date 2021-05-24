package com.example.booklist.model;

public class BookList {
    private String subject;
    private String writer;
    private String publisher;
    private int image;

    public BookList() {
    }

    public BookList(String subject, String writer, String publisher, int image) {
        this.subject = subject;
        this.writer = writer;
        this.publisher = publisher;
        this.image = image;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
