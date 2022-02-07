package com.example.projects.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projects.R;
import com.example.projects.entity.FeedItem;

import java.util.List;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewHolder>{
    List<FeedItem> mFeedItemList;
    Context mContext;

    public FeedRecyclerViewAdapter(List<FeedItem> feedItemList, Context context) {
        mFeedItemList = feedItemList;
        mContext = context;
    }

    @NonNull
    @Override
    public FeedRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_feed,parent,false);
        return new FeedRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedRecyclerViewHolder holder, int position) {
        holder.Username.setText(mFeedItemList.get(position).getUsername());
        holder.PostText.setText(mFeedItemList.get(position).getPostText());
    }

    @Override
    public int getItemCount() {
        return mFeedItemList.size();
    }
}
