package com.example.multiplerecyclerviews;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private TextView tvSong;
    private Button btnPlay;
    private Button btnPause;
    private MediaPlayer mediaPlayer;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvSong = itemView.findViewById(R.id.tvSong);
        btnPlay = itemView.findViewById(R.id.btnPlay);
        btnPause = itemView.findViewById(R.id.btnPause);
    }

    public void setData(ProfileModel profileModel){
        tvSong.setText(profileModel.getSong());
    }
}
