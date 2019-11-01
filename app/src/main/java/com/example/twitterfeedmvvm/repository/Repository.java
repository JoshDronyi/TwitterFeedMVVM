package com.example.twitterfeedmvvm.repository;

import com.example.twitterfeedmvvm.Retrofit.JokeInterface;
import com.example.twitterfeedmvvm.Retrofit.PictureInterface;
import com.example.twitterfeedmvvm.Retrofit.RetrofitInstance;
import com.example.twitterfeedmvvm.Utils.Constants;
import com.example.twitterfeedmvvm.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;

public class Repository implements PictureInterface, JokeInterface {

    //region Making Repository a singleton
    private Repository() {

    }

    static class RepositoryHolder {
        static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return RepositoryHolder.INSTANCE;
    }
    //endregion


    //region Methods to override interfaces
    @Override
    public Call<String> getImage(int width, int height) {
        return RetrofitInstance.changeBaseURL(Constants.BASE_IMAGE_URL)
                .create(PictureInterface.class)
                .getImage(width, height);
    }

    @Override
    public Call<String> getSquareImage(int count) {
        return RetrofitInstance.changeBaseURL(Constants.BASE_IMAGE_URL)
                .create(PictureInterface.class)
                .getSquareImage(count);
    }

    @Override
    public Call<String> getJoke() {

        return RetrofitInstance.changeBaseURL(Constants.BASE_JOKE_URL)
                .create(JokeInterface.class)
                .getJoke();
    }
    //endregion

    //Random genetators
    Random random = new Random();

    public static Date getRandomDate() {
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

    public User createUserNoImage(String username, String handle) {
        return new User.Builder()
                .Usernmae(username)
                .Handle(handle)
                .build();
    }
}
