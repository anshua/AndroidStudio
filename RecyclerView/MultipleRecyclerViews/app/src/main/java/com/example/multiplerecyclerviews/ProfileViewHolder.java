package com.example.multiplerecyclerviews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivProfile;
    private TextView tvAge;
    private TextView tvProfession;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        initItems(itemView);
    }

    private void initItems(View itemView) {
        ivProfile = itemView.findViewById(R.id.ivProfile);
        tvAge = itemView.findViewById(R.id.tvAge);
        tvProfession = itemView.findViewById(R.id.tvDescription);
    }

    public void setData(ProfileModel profileModel){
        ivProfile.setImageResource(profileModel.getImageID());
        tvAge.setText(profileModel.getAge());
        tvProfession.setText(profileModel.getDescription());
    }
}
