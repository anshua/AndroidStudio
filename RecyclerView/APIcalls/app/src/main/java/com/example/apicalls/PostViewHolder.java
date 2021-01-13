package com.example.apicalls;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvId;
    private TextView mTvUserId;
    private TextView mTvTitle;
    private TextView mTvBody;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        mTvId = itemView.findViewById(R.id.tvId);
        mTvUserId = itemView.findViewById(R.id.tvUserId);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvBody = itemView.findViewById(R.id.tvBody);
    }

    public void setData(ResponseClass responseClass){
        mTvId.setText(responseClass.getId()+"");
        mTvUserId.setText(responseClass.getUserId()+"");
        mTvTitle.setText(responseClass.getTitle());
        mTvBody.setText(responseClass.getBody());
    }
}
