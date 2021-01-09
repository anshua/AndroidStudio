package com.example.birdsrecyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BirdsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<BirdsModel> birdsModels;

    public BirdsAdapter(ArrayList<BirdsModel> birdsModels) {
        this.birdsModels = birdsModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BirdsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.birds, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BirdsModel birdsModel = birdsModels.get(position);
        ((BirdsViewHolder) holder).setData(birdsModel);
    }

    @Override
    public int getItemCount() {
        return birdsModels.size();
    }
}
