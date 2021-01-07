package com.example.identitycard;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IdentityCardViewHolder extends RecyclerView.ViewHolder {
    private TextView companyName;
    private TextView tvAge;
    private TextView tvProfession;
    private ImageView imProfile;

    public IdentityCardViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView){
        companyName = itemView.findViewById(R.id.tvCompany);
        tvAge = itemView.findViewById(R.id.tvAge);
        tvProfession = itemView.findViewById(R.id.tvProfession);
        imProfile = itemView.findViewById(R.id.ivProfile);
    }

    public void setData(IdentityCardModel identityCardModel){
        companyName.setText(identityCardModel.getCompanyName());
        tvAge.setText(identityCardModel.getTvAge());
        tvProfession.setText(identityCardModel.getTvProfession());
        imProfile.setImageResource(identityCardModel.getProfileImage());
    }
}
