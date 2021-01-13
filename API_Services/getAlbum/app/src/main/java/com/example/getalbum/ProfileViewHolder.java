package com.example.getalbum;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    private TextView id;
    private TextView userid;
    private TextView title;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.tvID);
        userid = itemView.findViewById(R.id.tvUserID);
        title = itemView.findViewById(R.id.tvTitle);
    }

    public void setData(Profile profile) {
        id.setText(profile.getId());
        userid.setText(profile.getUserid());
        title.setText(profile.getTitle());
    }
}
