package com.example.superhero5.repository;

import com.example.superhero5.entity.City;
import com.example.superhero5.entity.Hero;
import com.example.superhero5.entity.Power;
import com.example.superhero5.entity.PowerRelations;
import com.example.superhero5.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.sql.*;
import java.util.ArrayList;


public class DB implements DBI {

    //private Environment env;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user; //= env.getProperty("spring.datasource.username");

    @Value("${spring.datasource.password}")
    private String pwd;

    public DB(){
    }

    //READ-methods:
    public ArrayList<Hero> allHeroes(){
        ArrayList<Hero> resultList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13")) {
        //try{
            //Connection con = ConnectionManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13");
            String SQL = "select * from superheroesdata.superhero";
            ResultSet rs = con.createStatement().executeQuery(SQL);

            while (rs.next()){
                Hero hero = new Hero();
                hero.setHeroName(rs.getString("superheroname"));
                hero.setRealName(rs.getString("realname"));
                hero.setCreationYear(rs.getInt("creationyear"));
                resultList.add(hero);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public ArrayList<City> allCities(){
        ArrayList<City> resultList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13")) {
            String SQL = "select * from superheroesdata.city";
            ResultSet rs = con.createStatement().executeQuery(SQL);

            while (rs.next()){
                City city = new City();
                city.setCityId(rs.getInt("cityId"));
                city.setName(rs.getString("cityName"));
                //city.setHeroName(rs.getString("superhero"));
                resultList.add(city);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public ArrayList<Power> allPowers(){
        ArrayList<Power> resultList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13")) {
            String SQL = "select * from superheroesdata.superPower";
            ResultSet rs = con.createStatement().executeQuery(SQL);

            while (rs.next()){
                Power power = new Power();
                power.setPowerId(rs.getInt("powerId"));
                power.setName(rs.getString("power"));
                resultList.add(power);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public ArrayList<PowerRelations> allPowerRelations(){
        ArrayList<PowerRelations> resultList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13")) {
            String SQL = "select * from superheroesdata.powerrelation";
            ResultSet rs = con.createStatement().executeQuery(SQL);

            while (rs.next()){
                PowerRelations pR = new PowerRelations();
                pR.setPowerId(rs.getInt("powerId"));
                pR.setHeroName(rs.getString("superheroName"));
                resultList.add(pR);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    //CREATE-methods:
    public boolean addHero(Hero hero){
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13")) {
            String SQL = "insert into superheroesdata.superhero values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,hero.getHeroName() );
            ps.setString(2,hero.getRealName() );
            ps.setInt(3,hero.getCreationYear() );
            ps.setInt(4,hero.getCityId());
            //ps.executeQuery();
            ps.execute();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addPowerRelation(String heroName,Integer powerId) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13")) {
        //try {
            //Connection con = ConnectionManager.getConnection("jdbc:mysql://localhost:3306/superheroesdata","testuser", "Sivertsen13");
            String SQL = "insert into superheroesdata.powerrelation values (?,?)";
            PreparedStatement ps =con.prepareStatement(SQL);
            ps.setString(1, heroName);
            ps.setInt(2, powerId);
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
