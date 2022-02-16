package com.dzejju.ordering_app.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDiscountCodes implements ApplicationRunner {

    private DiscountCodesRepository repository;

    @Autowired
    public LoadDiscountCodes(DiscountCodesRepository repository) {
        this.repository = repository;
    }


    public void run(ApplicationArguments args) {
        repository.save(new DiscountCode("ggwp10", Long.parseLong("10")));
        repository.save(new DiscountCode("ggwp50", Long.parseLong("50")));
    }
}