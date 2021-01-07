package com.example.multipletypeview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LocationViewHolder extends RecyclerView.ViewHolder {
    private TextView tvLocation;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView){
        tvLocation = itemView.findViewById(R.id.tvLocationName);
    }

    public void setData(PersonalityModel personalityModel){
        tvLocation.setText(personalityModel.getLocationName());
    }
}
