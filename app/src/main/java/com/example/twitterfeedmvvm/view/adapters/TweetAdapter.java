package com.example.twitterfeedmvvm.view.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterfeedmvvm.R;
import com.example.twitterfeedmvvm.Utils.Constants;
import com.example.twitterfeedmvvm.model.Tweet;

import java.util.List;

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

        Drawable imageAsDrawable;

        switch (currentTweet.getSender().getImage()){
            case Constants.USER1_IMAGE:
                imageAsDrawable= context.getDrawable(R.drawable.realperson);
                break;
            case Constants.USER2_IMAGE:
                imageAsDrawable= context.getDrawable(R.drawable.anotherperson);
                break;
            case Constants.USER3_IMAGE:
                imageAsDrawable= context.getDrawable(R.drawable.troll);
                break;
                default:
                    imageAsDrawable = context.getDrawable(R.drawable.ic_launcher_background);
        }

        holder.ivUserImage.setImageDrawable(imageAsDrawable);

        //Set up Text views
        holder.tvUsername.setText(currentTweet.getSender().getUsername());
        holder.tvHandle.setText(currentTweet.getSender().getHandle());
        holder.tvMessage.setText(currentTweet.getMessage());




    }

    @Override
    public int getItemCount() {
        return newsFeed.size();
    }


    public class TweetViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivUserImage;
        public TextView tvUsername, tvHandle, tvMessage;
        public Button btnFollowing;

        public TweetViewHolder(@NonNull View itemView) {
            super(itemView);

            ivUserImage = itemView.findViewById(R.id.iv_user_image);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvHandle = itemView.findViewById(R.id.tv_user_handle);
            tvMessage = itemView.findViewById(R.id.tv_message);
            btnFollowing = itemView.findViewById(R.id.btn_follow);


        }
    }
}
