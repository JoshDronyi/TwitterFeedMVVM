package com.example.twitterfeedmvvm.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.twitterfeedmvvm.R;
import com.example.twitterfeedmvvm.Utils.Constants;
import com.example.twitterfeedmvvm.model.Tweet;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {

    private List<Tweet> newsFeed;
    private Context context;

    public TweetAdapter(List<Tweet> newsFeed) {
        this.newsFeed = newsFeed;
    }

    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View theView = LayoutInflater.from(context)
                .inflate(R.layout.feed_tweet,
                        parent,
                        false);
        return new TweetViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetViewHolder holder, int position) {
        Tweet currentTweet = newsFeed.get(position);

        //Set Up user Image


        Glide.with(context)
                .load(currentTweet.getSender().getImage())
                .fitCenter()
                .into(holder.ivUserImage);



        //Set up Text views
        holder.tvUsername.setText(currentTweet.getSender().getUsername());
        holder.tvHandle.setText(currentTweet.getSender().getHandle());
        holder.tvMessage.setText(currentTweet.getMessage());

        //Secondary Text View set up

        String retweets = String.valueOf(currentTweet.getRetweets());
        String likes = String.valueOf(currentTweet.getLikes());

        holder.tvRetweets.setText(retweets);
        holder.tvLikes.setText(likes);


        //Date Set up
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyy 'at' hh:MM a", Locale.US);
        String dateString = format.format(currentTweet.getTweetTime());
        holder.tvDate.setText(dateString);


    }

    @Override
    public int getItemCount() {
        return newsFeed.size();
    }


    class TweetViewHolder extends RecyclerView.ViewHolder {

        ImageView ivUserImage;
        TextView tvUsername, tvHandle, tvMessage;
        Button btnFollowing;
        TextView tvRetweets, tvLikes, tvDate;

        TweetViewHolder(@NonNull View itemView) {
            super(itemView);

            ivUserImage = itemView.findViewById(R.id.iv_user_image);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvHandle = itemView.findViewById(R.id.tv_user_handle);
            tvMessage = itemView.findViewById(R.id.tv_message);
            btnFollowing = itemView.findViewById(R.id.btn_follow);
            tvRetweets = itemView.findViewById(R.id.tv_retweet);
            tvLikes = itemView.findViewById(R.id.tv_likes);
            tvDate = itemView.findViewById(R.id.tv_date);


        }
    }
}
