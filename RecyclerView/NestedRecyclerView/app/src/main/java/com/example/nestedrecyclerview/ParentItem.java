package com.example.nestedrecyclerview;

import java.util.ArrayList;

public class ParentItem {
    private String title;
    private ArrayList<ChildItem> childItems;

    public ParentItem(String title, ArrayList<ChildItem> childItems) {
        this.title = title;
        this.childItems = childItems;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<ChildItem> getChildItems() {
        return childItems;
    }
}
