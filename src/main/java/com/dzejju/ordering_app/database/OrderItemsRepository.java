package com.dzejju.ordering_app.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsRepository extends CrudRepository<OrderItems, Long> {

    OrderItems findById(long id);


}