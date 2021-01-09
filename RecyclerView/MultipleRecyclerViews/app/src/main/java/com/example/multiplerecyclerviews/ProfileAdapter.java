package com.example.multiplerecyclerviews;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ProfileModel> profileModels;

    public ProfileAdapter(ArrayList<ProfileModel> profileModels) {
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Log.d("TAG", "onCreateViewHolder: " + viewType );

        switch (viewType) {
            case ProfileModel.ITEM_PROFILE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile, parent, false);
                return new ProfileViewHolder(view);
            case ProfileModel.ITEM_HEADER:
                Log.d("TAG", "onCreateViewHolder: Header");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
                return new HeaderViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music, parent, false);
                return new MusicViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProfileModel profileModel = profileModels.get(position);
        int viewType = profileModel.getViewType();
        switch (viewType){
            case ProfileModel.ITEM_PROFILE:
                if (holder instanceof  ProfileViewHolder){
                    ((ProfileViewHolder) holder).setData(profileModel);
                }
            case ProfileModel.ITEM_HEADER:
                Log.d("TAG", "onBindViewHolder: Anshuuuuu");
                if (holder instanceof  HeaderViewHolder){
                    ((HeaderViewHolder) holder).setData(profileModel);
                }
            case ProfileModel.ITEM_MUSIC:
                if (holder instanceof  MusicViewHolder){
                    ((MusicViewHolder) holder).setData(profileModel);
                }
        }
    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }
}
