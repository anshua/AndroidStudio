package com.example.identitycard;

public class IdentityCardModel {
    private int profileImage;
    private String companyName;
    private String tvAge;
    private String tvProfession;

    public IdentityCardModel(int profileImage, String companyName, String tvAge, String tvProfession) {
        this.profileImage = profileImage;
        this.companyName = companyName;
        this.tvAge = tvAge;
        this.tvProfession = tvProfession;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTvAge() {
        return tvAge;
    }

    public String getTvProfession() {
        return tvProfession;
    }
}
