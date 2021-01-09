package com.example.birdsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BirdsModel> birdsModels;
    private RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rview = findViewById(R.id.rvRecycle);
        buildData();
    }

    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rview.setLayoutManager(linearLayoutManager);
        BirdsAdapter birdsAdapter = new BirdsAdapter(birdsModels);
        rview.setAdapter(birdsAdapter);
    }

    private void buildData(){
        birdsModels = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            birdsModels.add(new BirdsModel(R.drawable.kingfisher, "Kingfisher"));
            birdsModels.add(new BirdsModel(R.drawable.parrot, "Parrot"));
            birdsModels.add(new BirdsModel(R.drawable.sparrow, "Sparrow"));
            birdsModels.add(new BirdsModel(R.drawable.kiwi, "Kiwi"));
        }
    }
}