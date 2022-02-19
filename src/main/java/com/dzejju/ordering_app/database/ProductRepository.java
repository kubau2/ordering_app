package com.dzejju.ordering_app.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findById(long id);

    List<Product> findAllByPrice(Double price);
}