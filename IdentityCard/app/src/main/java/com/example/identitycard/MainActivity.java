package com.example.identitycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<IdentityCardModel> modelArrayList;
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
        IdentityCardAdapter identityCardAdapter = new IdentityCardAdapter(modelArrayList);
        recyclerView.setAdapter(identityCardAdapter);
    }

    private void buildData(){
        modelArrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            if(i%3 == 0){
                modelArrayList.add(new IdentityCardModel(R.drawable.anshu,
                        "XPO Logistics", "Age: 23", "Profession: Engineer"));
            }
            else if(i%3 == 1){
                modelArrayList.add(new IdentityCardModel(R.drawable.steve_jobs,
                        "Apple", "Age: 67", "Profession: Business"));
            }
            else{
                modelArrayList.add(new IdentityCardModel(R.drawable.s_hawking,
                        "Hawkings", "Age: 72", "Profession: Scientist"));
            }
        }
    }
}