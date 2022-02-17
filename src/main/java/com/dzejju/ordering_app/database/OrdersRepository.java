package com.dzejju.ordering_app.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    Orders findById(long id);

    @Query("SELECT max(id) FROM Orders")
    public Long maxOrderID();

}