package com.dzejju.ordering_app.database;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findById(long id);

}