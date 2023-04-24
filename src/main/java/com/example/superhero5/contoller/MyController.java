package com.example.superhero5.contoller;


import com.example.superhero5.dto.CreateDTO;

import com.example.superhero5.repository.DB;
import com.example.superhero5.repository.DBI;
import com.example.superhero5.service.DBService;
import com.example.superhero5.service.DBServiceI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("superheroes")
public class MyController {

    DBI data = new DB();
    DBServiceI dataService = new DBService();


    @RequestMapping("")
    public String allHeroes(Model model){
        model.addAttribute("allHeroes",data.allHeroes());
        model.addAttribute("allCites",data.allCities());
        return "all_heroes_list";
    }

    @RequestMapping("powers/{heroName}")
    public String heroPower(@PathVariable String heroName, Model model){

        model.addAttribute("powers",data.allPowers());
        model.addAttribute("hero",heroName);
        model.addAttribute("relations",data.allPowerRelations());

        return "hero_power";
    }

    @RequestMapping("/register")
    public String registerHero(Model model){
        model.addAttribute("dto",new CreateDTO());
        model.addAttribute("cities", data.allCities());
        model.addAttribute("prs", data.allPowerRelations ());
        model.addAttribute("powers", data.allPowers());
        return "register_hero";
    }

    @PostMapping("/register")
    public String registerHero(@ModelAttribute("dto") CreateDTO dto){

        System.out.println("\nTestusdskrift:\n");
        System.out.println(dto.getHero().getHeroName());
        for(Integer i : dto.getPowerIdList()){
            System.out.println(i);
        }

        //dataService.addNewHeroToDB(dto);

        data.addHero(dto.getHero());
        for(Integer i : dto.getPowerIdList()) {
            data.addPowerRelation(dto.getHero().getHeroName(),i);
        }

        return "registration_confirmed";
    }




}
