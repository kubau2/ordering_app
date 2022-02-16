package com.dzejju.ordering_app.database;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {

    Stock findById(long id);

}