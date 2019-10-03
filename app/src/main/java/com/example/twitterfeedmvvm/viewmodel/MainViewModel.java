package com.example.twitterfeedmvvm.viewmodel;

import com.example.twitterfeedmvvm.model.Tweet;
import com.example.twitterfeedmvvm.repository.Repository;

import java.util.List;

public class MainViewModel {

    public MainViewModel(){

    }

    public List<Tweet> getTweets(){
        return Repository.getInstance()
                .getTweets();
    }

}
