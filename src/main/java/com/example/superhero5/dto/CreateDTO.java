package com.example.superhero5.dto;

import com.example.superhero5.entity.City;
import com.example.superhero5.entity.Hero;
import com.example.superhero5.entity.Power;
import java.util.ArrayList;

public class CreateDTO {
    private Hero hero;
    private String city;
    private ArrayList<Integer> powerIdList;

    public CreateDTO() {
    }

    public Hero getHero() {
        return hero;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Integer> getPowerIdList() {
        return powerIdList;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPowerIdList(ArrayList<Integer> powerIdList) {
        this.powerIdList = powerIdList;
    }

    public void addToPowerIdList(Integer powerId){
        this.powerIdList.add(powerId);
    }
}
