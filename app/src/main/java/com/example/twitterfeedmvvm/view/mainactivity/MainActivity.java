package com.example.twitterfeedmvvm.view.mainactivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterfeedmvvm.R;
import com.example.twitterfeedmvvm.view.adapters.TweetAdapter;
import com.example.twitterfeedmvvm.viewmodel.MainViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_feed)
    RecyclerView rvNewsFeed;
    MainViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvNewsFeed.setLayoutManager(manager);

        viewModel = new MainViewModel();

        TweetAdapter adapter = new TweetAdapter(viewModel.getTweets());
        rvNewsFeed.setAdapter(adapter);




    }
}
