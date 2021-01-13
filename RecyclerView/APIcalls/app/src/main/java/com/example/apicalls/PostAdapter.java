package com.example.apicalls;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private ArrayList<ResponseClass> responseClassArrayList;

    public PostAdapter(ArrayList<ResponseClass> responseClassArrayList) {
        this.responseClassArrayList = responseClassArrayList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        ResponseClass responseClass = responseClassArrayList.get(position);
        holder.setData(responseClass);
    }

    @Override
    public int getItemCount() {
        return responseClassArrayList.size();
    }

    public void updateRecyclerViewList(ArrayList<ResponseClass> responseClassArrayList) {
        this.responseClassArrayList = responseClassArrayList;
        notifyDataSetChanged();
        Log.d("Anshu", "data updated " + responseClassArrayList.size());
    }
}
