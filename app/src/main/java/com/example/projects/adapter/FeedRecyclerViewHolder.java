package com.example.projects.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projects.R;

public class FeedRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView Username, PostText;
    ImageView UserImage;

    public FeedRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        Username = itemView.findViewById(R.id.feed_user_name);
        PostText = itemView.findViewById(R.id.feed_post_text);
        UserImage = itemView.findViewById(R.id.feed_user_image);
    }
}
