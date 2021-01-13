package com.example.getalbum;

public class Profile {
    private String id;
    private String userid;
    private String title;

    public String getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getTitle() {
        return title;
    }

    public Profile(String id, String userid, String title) {
        this.id = id;
        this.userid = userid;
        this.title = title;
    }
}
