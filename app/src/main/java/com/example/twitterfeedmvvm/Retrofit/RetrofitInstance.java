package com.example.twitterfeedmvvm.Retrofit;

import com.example.twitterfeedmvvm.Utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance  {

    private RetrofitInstance(){

    }

    private static   class RetrofitInstanceHolder {
        private static Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        private  static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_IMAGE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        private static Retrofit changeBaseURL(String baseUrl) {
            return INSTANCE = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
    }

    public static Retrofit changeBaseURL(String baseUrl){
        return RetrofitInstanceHolder.changeBaseURL(baseUrl);
    }


    public static Retrofit getInstance(){
        return RetrofitInstanceHolder.INSTANCE;
    }






}
