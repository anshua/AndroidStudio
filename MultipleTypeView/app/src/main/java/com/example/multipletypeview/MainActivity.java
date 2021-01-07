package com.example.multipletypeview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<PersonalityModel> modelArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buildData();
        setRecycleView();
    }

    private void setRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PersonalityAdapter personalityAdapter = new PersonalityAdapter(modelArrayList);
        recyclerView.setAdapter(personalityAdapter);
    }
    private void buildData(){
        modelArrayList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            if(i%3 == 0){
                modelArrayList.add(new PersonalityModel(R.drawable.ma, "Madhuri",
                        "", PersonalityModel.ITEM_TYPE_PERSONALITY));
                modelArrayList.add(new PersonalityModel(0, "",
                        "Jakhauli", PersonalityModel.ITEM_TYPE_LOCATION));
            }
            else if(i%3 == 1){
                modelArrayList.add(new PersonalityModel(R.drawable.madhuri, "Madhuri & Anshu",
                        "", PersonalityModel.ITEM_TYPE_PERSONALITY));
                modelArrayList.add(new PersonalityModel(0, "",
                        "Bombay", PersonalityModel.ITEM_TYPE_LOCATION));
            }
            else{
                modelArrayList.add(new PersonalityModel(R.drawable.anshu, "Anshu",
                        "", PersonalityModel.ITEM_TYPE_PERSONALITY));
                modelArrayList.add(new PersonalityModel(0, "",
                        "Orai", PersonalityModel.ITEM_TYPE_LOCATION));
            }
        }
    }
}