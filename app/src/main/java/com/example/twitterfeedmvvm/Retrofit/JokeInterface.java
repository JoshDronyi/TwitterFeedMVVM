package com.example.twitterfeedmvvm.Retrofit;

import com.example.twitterfeedmvvm.Utils.Constants;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JokeInterface {

    @GET(Constants.JOKE_PATH)
    Call<String> getJoke();

}
