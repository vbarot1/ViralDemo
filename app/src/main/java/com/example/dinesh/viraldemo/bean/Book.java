package com.example.dinesh.viraldemo.bean;

import java.io.Serializable;

/**
 * Created by Dinesh on 2/15/2017.
 */

public class Book implements Serializable{

    private String name;
    private String author;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }





}
