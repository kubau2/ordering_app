package com.dzejju.ordering_app.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Long discountPercent;

    protected DiscountCode() {}

    public DiscountCode(String code, Long discountPercent) {
        this.code = code;
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return String.format(
                "Code [id=%d, code='%s', DiscountPercent='%d']",
                id, code, discountPercent);
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Long getDiscountPercent() {
        return discountPercent;
    }

}