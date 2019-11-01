package com.example.twitterfeedmvvm.view.mainactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterfeedmvvm.R;
import com.example.twitterfeedmvvm.Utils.Constants;
import com.example.twitterfeedmvvm.model.Message;
import com.example.twitterfeedmvvm.model.Tweet;
import com.example.twitterfeedmvvm.model.User;
import com.example.twitterfeedmvvm.view.adapters.TweetAdapter;
import com.example.twitterfeedmvvm.viewmodel.MainViewModel;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_feed)
    RecyclerView rvNewsFeed;
    MainViewModel viewModel;
    List<Tweet> newsFeed;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvNewsFeed.setLayoutManager(manager);

        viewModel = ViewModelProviders
                            .of(this)
                            .get(MainViewModel.class);


        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rvNewsFeed.addItemDecoration(divider);



        generateTweets(Constants.TWEET_COUNT);

    }
    //Should be done in Main.
    public List<Tweet> generateTweets(int count){
       newsFeed = new ArrayList<>();

       User user = viewModel.createUserNoImage("Immortal Tweeter", "@tooWitty2Die");
       Message message = new Message();

       for(int i = 0; i < count; i++){

           viewModel
                   .getMessage()
                   .enqueue(new Callback<String>() {
                       @Override
                       public void onResponse(Call<String> call, Response<String> response) {
                           Log.e("Successful Call", "Result of call was \n" + response.body());

                           message.setText(response.body());

                           Tweet newTweet = new Tweet.Builder()
                                                               .Sender(user)
                                                               .Message(message.getText())
                                                               .Likes(1)
                                                               .Retweets(1)
                                                               .TweetTime(viewModel.getRandomDate())
                                                               .build();
                           newsFeed.add(newTweet);
                           
                           if(newsFeed.size() <= Constants.TWEET_COUNT
                                   && newsFeed.size() != 0){
                               TweetAdapter adapter = new TweetAdapter(newsFeed);
                               rvNewsFeed.setAdapter(adapter);
                           }
                           
                           
                           //TODO Tweet object has message assigned here.
                       }

                       @Override
                       public void onFailure(Call<String> call, Throwable t) {
                           Log.e("Failed Call", "Result of call was \n" + call.toString());

                           t.printStackTrace();
                       }
                   });


       } //End of for loop
        return newsFeed;
    }

    /*
        newsFeed.add(new Tweet(user,"America is great. Lets all move there. Can i have money now.",1,263,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"You weren't supposed to say I was gonna pay you.",1,352,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"I didnt say that idiot.",1,332,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"I'm just here for the entertainment. Please continue.",1,3168,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"This is a presidential matter. I mean private matter.",1,943,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"Yea this is getting great. ",1,3151,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"This is what our country is all about.",1,553,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"Shut up Karen.",1,251,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"No FAAAIIIR!!",1,561,Repository.getRandomDate()));
        newsFeed.add(new Tweet(user,"Seriously, shut up Karen.",1,752,Repository.getRandomDate()));*/


}
