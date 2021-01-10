package com.example.nestedrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private ArrayList<ParentItem> parentItemArrayList;

    public ParentAdapter(ArrayList<ParentItem> parentItemArrayList) {
        this.parentItemArrayList = parentItemArrayList;
        Log.d("TAG", "ParentAdapter: constructor onBind " + getItemCount());
    }


    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        ParentItem parentItem = parentItemArrayList.get(position);
        holder.TitleName.setText(parentItem.getTitle());
        Log.d("TAG", "onBindViewHolder: " + holder.TitleName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.ChildRecycler.getContext(), RecyclerView.HORIZONTAL, true);
        linearLayoutManager.setInitialPrefetchItemCount(parentItem.getChildItems().size());
        ChildAdapter childAdapter = new ChildAdapter(parentItem.getChildItems());
        holder.ChildRecycler.setLayoutManager(linearLayoutManager);
        holder.ChildRecycler.setAdapter(childAdapter);
        holder.ChildRecycler.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return parentItemArrayList.size();
    }
    public class ParentViewHolder extends RecyclerView.ViewHolder {

        public TextView TitleName;
        public RecyclerView ChildRecycler;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            TitleName = itemView.findViewById(R.id.parentTitle);
            ChildRecycler = itemView.findViewById(R.id.childRecyclerView);
        }
    }
}
