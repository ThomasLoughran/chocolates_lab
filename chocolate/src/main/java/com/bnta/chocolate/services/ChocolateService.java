package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public Chocolate addChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public List<Chocolate> getAllChocolates(){
        List<Chocolate> chocolates = chocolateRepository.findAll();
        return chocolates;
    }

    public void removeChocolateById(long id){
        chocolateRepository.deleteById(id);
    }

    public Optional<Chocolate> getChocolateById(long id){
        Optional<Chocolate> optionalChocolate = chocolateRepository.findById(id);
        return optionalChocolate;
    }

}
