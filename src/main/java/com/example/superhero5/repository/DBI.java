package com.example.superhero5.repository;

import com.example.superhero5.entity.City;
import com.example.superhero5.entity.Hero;
import com.example.superhero5.entity.Power;
import com.example.superhero5.entity.PowerRelations;

import java.util.ArrayList;

public interface DBI {
    //READ-methods:
    ArrayList<Hero> allHeroes();
    ArrayList<City> allCities();
    ArrayList<Power> allPowers();
    ArrayList<PowerRelations> allPowerRelations();

    //CREATE-methods:
    boolean addHero(Hero hero);
    boolean addPowerRelation(String heroName,Integer powerId);
}
