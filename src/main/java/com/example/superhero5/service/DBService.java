package com.example.superhero5.service;

import com.example.superhero5.dto.CreateDTO;
import com.example.superhero5.entity.PowerRelations;
import com.example.superhero5.repository.DB;
import com.example.superhero5.repository.DBI;
import org.springframework.stereotype.Service;

@Service
public class DBService implements DBServiceI {
    DBI data = new DB();
    public void addNewHeroToDB(CreateDTO dto){
        data.addHero(dto.getHero());
        for(Integer i : dto.getPowerIdList()) {
            data.addPowerRelation(dto.getHero().getHeroName(),i);
        }
    }

}
