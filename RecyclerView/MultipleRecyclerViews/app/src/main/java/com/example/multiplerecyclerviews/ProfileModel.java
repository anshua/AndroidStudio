package com.example.multiplerecyclerviews;

import android.util.Log;

public class ProfileModel {

    public static final int ITEM_PROFILE = 0;
    public static final int ITEM_HEADER = 1;
    public static final int ITEM_MUSIC = 2;

    private int imageID;
    private String age;
    private String description;
    private String name;
    private String songName;
    private int song;
    private int viewType;

    public ProfileModel(int imageID, String age, String description, String name, String songName, int song, int viewType) {
        this.imageID = imageID;
        this.age = age;
        this.description = description;
        this.name = name;
        this.songName = songName;
        this.song = song;
        this.viewType = viewType;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public String getSongName() {
        return songName;
    }

    public int getSong() {
        return song;
    }

    public int getViewType() {
        return viewType;
    }
}
