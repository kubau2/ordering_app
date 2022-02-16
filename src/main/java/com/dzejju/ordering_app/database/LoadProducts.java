package com.dzejju.ordering_app.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadProducts implements ApplicationRunner {

    private ProductRepository productRepository;

    private StockRepository stockRepository;

    @Autowired
    public LoadProducts(ProductRepository productRepository, StockRepository stockRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }


    public void run(ApplicationArguments args) {
        Product product = new Product("Jabluszko");
        productRepository.save(product);
        Stock stock = new Stock(product.getId(), 10);
        stockRepository.save(stock);

        product = new Product("Pierniki");
        productRepository.save(product);
        stock = new Stock(product.getId(), 20);
        stockRepository.save(stock);
    }
}