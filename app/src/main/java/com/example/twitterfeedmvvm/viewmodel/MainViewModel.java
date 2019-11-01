package com.example.twitterfeedmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.twitterfeedmvvm.model.User;
import com.example.twitterfeedmvvm.repository.Repository;

import java.util.Date;

import retrofit2.Call;

public class MainViewModel extends AndroidViewModel {


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public User createUserNoImage(String username, String handle) {
        return  Repository.getInstance()
                .createUserNoImage(username,handle);
    }

    public Call<String> getUserImage(int width, int height){
        return Repository.getInstance().getImage(width,height);
    }

    public Call<String> getMessage(){
        return Repository.getInstance().getJoke();
    }

    public Date getRandomDate() {
        return Repository.getRandomDate();
    }
}
