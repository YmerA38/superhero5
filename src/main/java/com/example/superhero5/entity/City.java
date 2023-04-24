package com.example.superhero5.entity;

public class City {
    private  int cityId;
    private String cityName;


    public City() {
    }

    public void setName(String name) {
        this.cityName = name;
    }



    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return cityName;
    }



    public int getCityId() {
        return cityId;
    }
}
