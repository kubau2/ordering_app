package com.dzejju.ordering_app.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadProducts implements ApplicationRunner {

    private ProductRepository repository;

    @Autowired
    public LoadProducts(ProductRepository repository) {
        this.repository = repository;
    }


    public void run(ApplicationArguments args) {
        repository.save(new Product("Jabluszko", 2));
        repository.save(new Product("Pierniki", 10));
    }
}