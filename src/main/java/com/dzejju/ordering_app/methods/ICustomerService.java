package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.Cart;

public interface ICustomerService {

    public abstract void addCustomerData(Long customerId, String firstName, String lastName, String address);
 //   public abstract void updateProduct(String id, Product product);
 //   public abstract void deleteProduct(String id);


}
