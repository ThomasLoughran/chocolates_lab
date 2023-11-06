package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    @Autowired
    EstateRepository estateRepository;

    public Estate addEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }

    public List<Estate> getAllEstates(){
        List<Estate> estates = estateRepository.findAll();
        return estates;
    }

    public void removeEstateById(long id){
        estateRepository.deleteById(id);
    }

    public Optional<Estate> getEstateById(long id){
        Optional<Estate> optionalEstate = estateRepository.findById(id);
        return optionalEstate;
    }

}
