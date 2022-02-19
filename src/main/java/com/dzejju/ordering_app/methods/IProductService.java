package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.Cart;
import com.dzejju.ordering_app.database.Product;

import java.util.List;

public interface IProductService {

   // public abstract void addProduct(String Name);
    public abstract Product getProductById(Long ID);
    public abstract String viewProducts();
    public abstract String viewProductsDetails();
    public abstract String viewByPrice(Double price);

    //   public abstract void updateProduct(String id, Product product);
 //   public abstract void deleteProduct(String id);


}
