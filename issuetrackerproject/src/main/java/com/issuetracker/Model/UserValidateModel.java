package com.issuetracker.Model;

public class UserValidateModel {
    public String username;
    public boolean user_exist;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isUser_exist() {
        return user_exist;
    }

    public void setUser_exist(boolean user_exist) {
        this.user_exist = user_exist;
    }
}
