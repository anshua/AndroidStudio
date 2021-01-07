package com.example.multipletypeview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonalityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<PersonalityModel> modelArrayList;

    public PersonalityAdapter(ArrayList<PersonalityModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case PersonalityModel.ITEM_TYPE_PERSONALITY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personality_item_layout, parent, false);
                return new PersonalityViewHolder(view);
            case PersonalityModel.ITEM_TYPE_LOCATION:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_item_layout, parent, false);
                return new LocationViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personality_item_layout, parent, false);
                return new PersonalityViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonalityModel personalityModel = modelArrayList.get(position);
        int viewType = personalityModel.getViewType();

        switch (viewType){
            case PersonalityModel.ITEM_TYPE_PERSONALITY:
                if(holder instanceof PersonalityViewHolder){
                    ((PersonalityViewHolder) holder).setData(personalityModel);
                }
                break;
            case PersonalityModel.ITEM_TYPE_LOCATION:
                if (holder instanceof LocationViewHolder){
                    ((LocationViewHolder) holder).setData(personalityModel);
                }
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return modelArrayList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
