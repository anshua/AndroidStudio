package com.example.nestedrecyclerview;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildViewHolder extends RecyclerView.ViewHolder {

    private ImageView childImage;

    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);

        childImage = itemView.findViewById(R.id.childImage);
    }

    public void setData(ChildItem childItem){
        childImage.setImageResource(childItem.getImageId());
    }

}
