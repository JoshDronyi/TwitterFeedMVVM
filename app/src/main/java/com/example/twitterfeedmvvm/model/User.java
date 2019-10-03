package com.example.twitterfeedmvvm.model;

public class User {
    private String username;
    private String image;
    private String handle;

    public User(String username, String image, String handle) {
        this.username = username;
        this.image = image;
        this.handle = handle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
