package com.example.twitterfeedmvvm.model;

import java.util.Calendar;
import java.util.Date;

public class Tweet {

    private User sender;
    private String message;
    private int likes;
    private int retweets;
    private Date tweetTime;

    public Tweet(User sender, String message, int likes, int retweets, Date tweetTime) {
        this.sender = sender;
        this.message = message;
        this.likes = likes;
        this.retweets = retweets;
        this.tweetTime = tweetTime;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public Date getTweetTime() {
        return tweetTime;
    }

    public void setTweetTime(Date tweetTime) {
        this.tweetTime = tweetTime;
    }
}
