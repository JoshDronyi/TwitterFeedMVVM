package com.example.twitterfeedmvvm.model;

import com.example.twitterfeedmvvm.Utils.Constants;

public class User {
    private String username;
    private String image;
    private String handle;

    public User(Builder builder) {
        this.username = builder.username;
        this.image = builder.image;
        this.handle = builder.handle;
    }

    public String getUsername() {
        return username;
    }

    public String getImage() {
        return image;
    }

    public String getHandle() {
        return handle;
    }


    public static class Builder {
        private String username;
        private String image;
        private String handle;

        public Builder Usernmae(String username) {
            this.username = username;
            return this;
        }

        public Builder Image(String image) {
            this.image = Constants.PICTURE_INJECTION_URL;
            return this;
        }

        public Builder Handle(String handle) {
            this.handle = handle;
            return this;
        }

        public User build(){
            return  new User(this);
        }
    }
}
