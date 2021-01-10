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
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        initData();
        setRecyclerView();
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
                        "", "", 0, ProfileModel.ITEM_PROFILE));
                profileModels.add(new ProfileModel(0,"", "",
                        "Mahendra Singh Dhoni", "", 0, ProfileModel.ITEM_HEADER));
                profileModels.add(new ProfileModel(0,"", "",
                        "", "Jab tak", R.raw.shape_of_you, ProfileModel.ITEM_MUSIC));
            }
            else if(i%3 == 1){
                profileModels.add(new ProfileModel(R.drawable.dhing, "Age: 20","Athelete",
                        "", "", 0, ProfileModel.ITEM_PROFILE));
                profileModels.add(new ProfileModel(0,"", "",
                        "Hima Das", "", 0, ProfileModel.ITEM_HEADER));
                profileModels.add(new ProfileModel(0,"", "",
                        "", "Chennai Express", R.raw.shape_of_you, ProfileModel.ITEM_MUSIC));
            }
            else{
                profileModels.add(new ProfileModel(R.drawable.smriti,"Age: 23","Cricketer",
                        "", "", 0, ProfileModel.ITEM_PROFILE));
                profileModels.add(new ProfileModel(0,"", "",
                        "Smriti Mandhana", "", 0, ProfileModel.ITEM_HEADER));
                profileModels.add(new ProfileModel(0,"", "",
                        "", "Chak de India", R.raw.shape_of_you, ProfileModel.ITEM_MUSIC));
            }
        }
    }
}