package com.example.multiplerecyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ProfileModel> profileModels;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        recyclerView = findViewById(R.id.recyclerView);
//        initData();
//        setRecyclerView();
    }

    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProfileAdapter profileAdapter = new ProfileAdapter(profileModels);
        recyclerView.setAdapter(profileAdapter);
    }

    private void initData() {
        profileModels = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            if(i%3 == 0){
                profileModels.add(new ProfileModel(R.drawable.dhoni,"Age: 39", "Cricketer",
                        "", "", ProfileModel.ITEM_PROFILE));
                profileModels.add(new ProfileModel(0,"", "",
                        "Mahendra Singh Dhoni", "", ProfileModel.ITEM_HEADER));
                profileModels.add(new ProfileModel(0,"", "",
                        "", "Jab tak", ProfileModel.ITEM_MUSIC));
            }
            else if(i%3 == 1){
                profileModels.add(new ProfileModel(R.drawable.dhing, "Age: 20","Athelete",
                        "", "", ProfileModel.ITEM_PROFILE));
                profileModels.add(new ProfileModel(0,"", "",
                        "Hima Das", "", ProfileModel.ITEM_HEADER));
                profileModels.add(new ProfileModel(0,"", "",
                        "", "Chennai Express", ProfileModel.ITEM_MUSIC));
            }
            else{
                profileModels.add(new ProfileModel(R.drawable.smriti,"Age: 23","Cricketer",
                        "", "", ProfileModel.ITEM_PROFILE));
                profileModels.add(new ProfileModel(0,"", "",
                        "Smriti Mandhana", "", ProfileModel.ITEM_HEADER));
                profileModels.add(new ProfileModel(0,"", "",
                        "", "Chak de India", ProfileModel.ITEM_MUSIC));
            }
        }
    }
}