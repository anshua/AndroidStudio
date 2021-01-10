package com.example.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.parentRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ParentAdapter parentAdapter = new ParentAdapter(ParentItemList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(parentAdapter);
    }

    private ArrayList<ParentItem> ParentItemList() {
        ArrayList<ParentItem> parentItems = new ArrayList<>();
        ParentItem parentItem = new ParentItem("Cricketer", ChildCricketerList());
        ParentItem parentItem1 = new ParentItem("Engineer", ChildEngineerList());
        ParentItem parentItem2 = new ParentItem("Business", ChildBusinessList());
        ParentItem parentItem3 = new ParentItem("Football", ChildFootballList());
        ParentItem parentItem4 = new ParentItem("Birds", ChildBirdsList());
        ParentItem parentItem5 = new ParentItem("Animals", ChildAnimalList());

        parentItems.add(parentItem);
        parentItems.add(parentItem1);
        parentItems.add(parentItem2);
        parentItems.add(parentItem3);
        parentItems.add(parentItem4);
        parentItems.add(parentItem5);
        return parentItems;
    }

    private ArrayList<ChildItem> ChildAnimalList() {
        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(new ChildItem(R.drawable.dhoni));
        childItems.add(new ChildItem(R.drawable.dhawan));
        childItems.add(new ChildItem(R.drawable.smriti));
        childItems.add(new ChildItem(R.drawable.rohit));
        childItems.add(new ChildItem(R.drawable.virat));

        return childItems;
    }

    private ArrayList<ChildItem> ChildBirdsList() {
        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(new ChildItem(R.drawable.dhoni));
        childItems.add(new ChildItem(R.drawable.dhawan));
        childItems.add(new ChildItem(R.drawable.smriti));
        childItems.add(new ChildItem(R.drawable.rohit));
        childItems.add(new ChildItem(R.drawable.virat));

        return childItems;
    }

    private ArrayList<ChildItem> ChildFootballList() {
        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(new ChildItem(R.drawable.dhoni));
        childItems.add(new ChildItem(R.drawable.dhawan));
        childItems.add(new ChildItem(R.drawable.smriti));
        childItems.add(new ChildItem(R.drawable.rohit));
        childItems.add(new ChildItem(R.drawable.virat));

        return childItems;
    }

    private ArrayList<ChildItem> ChildBusinessList() {
        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(new ChildItem(R.drawable.dhoni));
        childItems.add(new ChildItem(R.drawable.dhawan));
        childItems.add(new ChildItem(R.drawable.smriti));
        childItems.add(new ChildItem(R.drawable.rohit));
        childItems.add(new ChildItem(R.drawable.virat));

        return childItems;
    }

    private ArrayList<ChildItem> ChildEngineerList() {
        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(new ChildItem(R.drawable.elonmusk));
        childItems.add(new ChildItem(R.drawable.edison));
        childItems.add(new ChildItem(R.drawable.pichai));
        childItems.add(new ChildItem(R.drawable.pichai));
        childItems.add(new ChildItem(R.drawable.jeff));

        return childItems;
    }

    private ArrayList<ChildItem> ChildCricketerList() {
        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(new ChildItem(R.drawable.dhoni));
        childItems.add(new ChildItem(R.drawable.dhawan));
        childItems.add(new ChildItem(R.drawable.smriti));
        childItems.add(new ChildItem(R.drawable.rohit));
        childItems.add(new ChildItem(R.drawable.virat));

        return childItems;
    }


}