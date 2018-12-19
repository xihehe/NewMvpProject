package com.example.fc.newmvpproject.TabPageModule.Modle;

public class TabModle {

    private String title; // 文字
    private int icon; // 图标
    private Class fragment; // 对应fragment


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
