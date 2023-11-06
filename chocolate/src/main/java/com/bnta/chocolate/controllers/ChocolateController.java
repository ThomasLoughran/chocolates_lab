package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @PostMapping
    public ResponseEntity<Chocolate> newChocolate(@RequestBody Chocolate chocolate){
        Chocolate addedChocolate = chocolateService.addChocolate(chocolate);
        return new ResponseEntity<>(addedChocolate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        List<Chocolate> chocolateList = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolateList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Optional<Chocolate> optionalChocolate = chocolateService.getChocolateById(id);

        if (optionalChocolate.isPresent()){
            return new ResponseEntity<>(optionalChocolate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeChocolateById(@PathVariable long id){
        chocolateService.removeChocolateById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
