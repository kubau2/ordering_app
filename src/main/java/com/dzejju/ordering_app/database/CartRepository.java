package com.dzejju.ordering_app.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {

     Cart findById(long id);

     Cart findByproductId(long id);

     List<Cart> findAllByCustomerID(long id);

     void deleteAllByCustomerID(long id);
}