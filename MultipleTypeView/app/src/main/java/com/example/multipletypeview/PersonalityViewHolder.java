package com.example.multipletypeview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class PersonalityViewHolder extends RecyclerView.ViewHolder {

    private ImageView imVPerson;
    private TextView mTVName;

    public PersonalityViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView){
        imVPerson = itemView.findViewById(R.id.tvPersonality);
        mTVName = itemView.findViewById(R.id.tvName);
    }

    public void setData(PersonalityModel personalityModel){
        imVPerson.setImageResource(personalityModel.getImageID());
        mTVName.setText(personalityModel.getPersonalityName());
    }
}
