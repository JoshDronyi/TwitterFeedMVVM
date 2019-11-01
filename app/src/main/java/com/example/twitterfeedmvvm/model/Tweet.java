package com.example.twitterfeedmvvm.model;

import java.util.Date;

public class Tweet {

    private User sender;
    private String message;
    private int likes;
    private int retweets;
    private Date tweetTime;

    public Tweet(Builder builder) {
        this.sender = builder.sender;
        this.message = builder.message;
        this.likes = builder.likes;
        this.retweets = builder.retweets;
        this.tweetTime = builder.tweetTime;
    }


    public User getSender() {
        return sender;
    }


    public String getMessage() {
        return message;
    }


    public int getLikes() {
        return likes;
    }


    public int getRetweets() {
        return retweets;
    }


    public Date getTweetTime() {
        return tweetTime;
    }


    public static class Builder {
        private User sender;
        private String message;
        private int likes;
        private int retweets;
        private Date tweetTime;

        public Builder Sender(User sender) {
            this.sender = sender;
            return this;
        }

        public Builder Message(String message) {
            this.message = message;
            return this;
        }

        public Builder Likes(int likes) {
            this.likes = likes;
            return this;
        }

        public Builder Retweets(int retweets) {
            this.retweets = retweets;
            return this;
        }

        public Builder TweetTime(Date tweetTime) {
            this.tweetTime = tweetTime;
            return this;
        }

        public Tweet build (){
            return  new Tweet(this);
        }

    }
}
