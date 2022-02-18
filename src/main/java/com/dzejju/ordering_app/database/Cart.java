package com.dzejju.ordering_app.database;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Integer amount;
    private Long customerID;
    private String discountCode;

//    @ElementCollection
//    @CollectionTable(name = "Cart_product",
//            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "item_name")
//    @Column(name = "amount")
//    private Map<Product, Integer> products = new HashMap<Product, Integer>();  //product + amount

    public Cart() {}


    public Long getProductId() {
        return productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }



//    public Map<Product, Integer> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Product product, Integer amount) {
//        this.products.put(product,amount);
//    }


//    public void setId(Long id) {
//        this.id = id;
//    }

    public void setProductAmount(Long product, Integer amount){
        this.productId = product;
        this.amount = amount;
    }


    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }



}