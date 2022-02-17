package com.dzejju.ordering_app.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findById(long id);

    @Query("SELECT max(customerID) FROM Order")
    public Long maxOrderID();


}