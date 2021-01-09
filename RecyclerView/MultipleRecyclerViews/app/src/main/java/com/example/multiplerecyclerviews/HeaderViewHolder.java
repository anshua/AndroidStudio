package com.example.multiplerecyclerviews;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private TextView tvHeaderName;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvHeaderName = itemView.findViewById(R.id.tvName);
    }

    public void setData(ProfileModel profileModel){
        Log.d("TAG", profileModel.getName() + "234567");
        tvHeaderName.setText(profileModel.getName());
    }

}
