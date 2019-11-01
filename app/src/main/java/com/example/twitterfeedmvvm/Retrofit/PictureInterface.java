package com.example.twitterfeedmvvm.Retrofit;

import com.example.twitterfeedmvvm.Utils.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PictureInterface {
    @GET(Constants.PICTURE_PATH + "{width}/{height}")
    Call<String> getImage(@Path("width") int width, @Path("height") int height);

    @GET(Constants.PICTURE_PATH + "{size}")
    Call<String> getSquareImage(@Path("size") int size);


}
