package com.example.twitterfeedmvvm.repository;

import com.example.twitterfeedmvvm.model.Tweet;
import com.example.twitterfeedmvvm.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Repository {

    User user1,user2, user3;

    private Repository(){

        user1 = new User("totallyREALperson","anotherperson","@gimmeMoneyplz");
        user3 = new User("Any1ButMeNow","realperson","@iworkforrussia");
        user2 = new User("ThisIsAName","troll","@trollofalltrolls");

    }

    static  class RepositoryHolder{
        static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance(){
        return RepositoryHolder.INSTANCE;
    }


    public List<Tweet> getTweets(){
        List<Tweet> newsFeed = new ArrayList<>();

        newsFeed.add(new Tweet(user1,"America is great. Lets all move there. Can i have money now.",1,263,getRandomDate()));
        newsFeed.add(new Tweet(user2,"You weren't supposed to say I was gonna pay you.",1,352,getRandomDate()));
        newsFeed.add(new Tweet(user1,"I didnt say that idiot.",1,332,getRandomDate()));
        newsFeed.add(new Tweet(user3,"I'm just here for the entertainment. Please continue.",1,3168,getRandomDate()));
        newsFeed.add(new Tweet(user2,"This is a presidential matter. I mean private matter.",1,943,getRandomDate()));
        newsFeed.add(new Tweet(user3,"Yea this is getting great. ",1,3151,getRandomDate()));
        newsFeed.add(new Tweet(user1,"This is what our country is all about.",1,553,getRandomDate()));
        newsFeed.add(new Tweet(user3,"Shut up Karen.",1,251,getRandomDate()));
        newsFeed.add(new Tweet(user2,"No FAAAIIIR!!",1,561,getRandomDate()));
        newsFeed.add(new Tweet(user1,"Seriously, shut up Karen.",1,752,getRandomDate()));

        return newsFeed;
    }

    private Date getRandomDate() {
        int day = new Random().nextInt((31 - 1) + 1) + 1;
        int month = new Random().nextInt((12 - 1) + 1) + 1;
        int year = new Random().nextInt((2019 - 1900) + 1) + 1900;




        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        try {
            date = sdf.parse(day + "/" + month + "/" + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
