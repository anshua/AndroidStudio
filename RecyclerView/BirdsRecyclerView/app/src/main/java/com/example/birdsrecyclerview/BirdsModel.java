package com.example.birdsrecyclerview;

public class BirdsModel {
    private int imageId;
    private String name;

    public BirdsModel(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

}
