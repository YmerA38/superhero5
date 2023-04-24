package com.example.superhero5.entity;

import java.util.ArrayList;

public class Hero {
    private String heroName;
    private String realName;
    private int creationYear;
    private int cityId;

    public Hero() {
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public int getCityId() {
        return cityId;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
