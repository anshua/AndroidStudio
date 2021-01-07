package com.example.multipletypeview;

public class PersonalityModel  {
    public static final int ITEM_TYPE_PERSONALITY = 0;
    public static final int ITEM_TYPE_LOCATION = 1;

    private int imageID;
    private String personalityName;
    private String locationName;
    private int viewType;

    public PersonalityModel(int imageID, String personalityName, String locationName, int viewType) {
        this.imageID = imageID;
        this.personalityName = personalityName;
        this.locationName = locationName;
        this.viewType = viewType;
    }

    public int getImageID() {
        return imageID;
    }

    public String getPersonalityName() {
        return personalityName;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getViewType() {
        return viewType;
    }
}
