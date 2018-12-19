package com.example.fc.newmvpproject.TabPageModule.Modle;

public class PageItem {

    private String title;
    private Class fragment; // 对应fragment


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
