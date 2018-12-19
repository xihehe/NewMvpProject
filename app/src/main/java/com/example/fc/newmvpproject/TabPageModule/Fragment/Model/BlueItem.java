package com.example.fc.newmvpproject.TabPageModule.Fragment.Model;

public class BlueItem {

    String title;
    String name;
    String url;

    public BlueItem(String title, String name, String url) {
        this.title = title;
        this.name = name;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
