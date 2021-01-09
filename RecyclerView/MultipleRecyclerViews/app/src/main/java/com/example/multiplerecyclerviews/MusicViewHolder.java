package com.example.multiplerecyclerviews;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private TextView tvSong;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvSong = itemView.findViewById(R.id.tvSong);
    }

    public void setData(ProfileModel profileModel){
        tvSong.setText(profileModel.getSong());
    }
}
