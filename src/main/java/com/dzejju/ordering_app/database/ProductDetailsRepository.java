package com.dzejju.ordering_app.database;

import org.springframework.data.repository.CrudRepository;

public interface ProductDetailsRepository extends CrudRepository<ProductDetails, Long> {

    ProductDetails findById(long id);
}