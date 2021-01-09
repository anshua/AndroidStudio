package com.example.birdsrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BirdsViewHolder extends RecyclerView.ViewHolder {
    private ImageView imBird;
    private TextView tvName;

    public BirdsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        imBird = itemView.findViewById(R.id.ivBird);
        tvName = itemView.findViewById(R.id.tvName);
    }

    public void setData(BirdsModel birdsModel){
        imBird.setImageResource(birdsModel.getImageId());
        tvName.setText(birdsModel.getName());
    }
}
