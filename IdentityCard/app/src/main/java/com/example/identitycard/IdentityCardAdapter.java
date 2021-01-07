package com.example.identitycard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IdentityCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<IdentityCardModel> modelArrayList;

    public IdentityCardAdapter(ArrayList<IdentityCardModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_id_card, parent, false);
        return new IdentityCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        IdentityCardModel identityCardModel = modelArrayList.get(position);
        ((IdentityCardViewHolder) holder).setData(identityCardModel);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
