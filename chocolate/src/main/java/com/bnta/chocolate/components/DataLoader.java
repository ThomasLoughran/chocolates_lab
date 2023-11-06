package com.bnta.chocolate.components;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    public void run(ApplicationArguments args){
        Estate tomsChocolates = new Estate("Tom's Choc", "Bahamas");
        estateService.addEstate(tomsChocolates);


        Chocolate bounty = new Chocolate("Bounty", 7, tomsChocolates);
        Chocolate mars = new Chocolate("Mars", 14, tomsChocolates);
        Chocolate darkChocolate = new Chocolate("Dark", 70, tomsChocolates);

        chocolateService.addChocolate(bounty);
        chocolateService.addChocolate(mars);
        chocolateService.addChocolate(darkChocolate);



    }
}
