package com.dzejju.ordering_app.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiscountCodesRepository extends CrudRepository<DiscountCode, Long> {

    DiscountCode findById(long id);

    DiscountCode findByCode(String code);
}