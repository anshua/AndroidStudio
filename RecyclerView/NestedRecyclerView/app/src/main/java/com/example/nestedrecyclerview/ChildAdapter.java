package com.example.nestedrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ChildItem> childItemArrayList;

    public ChildAdapter(ArrayList<ChildItem> childItemArrayList) {
        this.childItemArrayList = childItemArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChildItem childItem = childItemArrayList.get(position);
        ((ChildViewHolder) holder).setData(childItem);
    }

    @Override
    public int getItemCount() {
        return childItemArrayList.size();
    }
}
