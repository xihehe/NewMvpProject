package com.example.fc.newmvpproject.TestModule.EasyThreadModule;

/**
 * Created by haoge on 2017/4/20.
 */

public class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
