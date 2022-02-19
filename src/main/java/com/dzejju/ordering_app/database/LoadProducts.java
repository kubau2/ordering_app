package com.dzejju.ordering_app.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadProducts implements ApplicationRunner {

    private ProductRepository productRepository;

    private ProductDetailsRepository productDetailsRepository;

    private StockRepository stockRepository;

    public LoadProducts(ProductRepository productRepository, ProductDetailsRepository productDetailsRepository, StockRepository stockRepository) {
        this.productRepository = productRepository;
        this.productDetailsRepository = productDetailsRepository;
        this.stockRepository = stockRepository;
    }

    public void run(ApplicationArguments args) {
        Product product = new Product("Jabluszko", Double.valueOf(2.5));
        productRepository.save(product);
        Stock stock = new Stock(product.getId(), 10);
        stockRepository.save(stock);
        ProductDetails productDetails = new ProductDetails(5l, "For everyone");
        productDetailsRepository.save(productDetails);
        product = new Product("Piernik", Double.valueOf(5));
        productRepository.save(product);
        stock = new Stock(product.getId(), 20);
        stockRepository.save(stock);

        productDetails = new ProductDetails(3l, "For adults");
        productDetailsRepository.save(productDetails);

        product = new Product("Ciastko", Double.valueOf(2.5));
        productRepository.save(product);
        stock = new Stock(product.getId(), 10);
        stockRepository.save(stock);
        productDetails = new ProductDetails(5l, "For everyone");
        productDetailsRepository.save(productDetails);
    }
}