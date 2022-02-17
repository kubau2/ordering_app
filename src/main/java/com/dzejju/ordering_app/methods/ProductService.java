package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.Cart;
import com.dzejju.ordering_app.database.CartRepository;
import com.dzejju.ordering_app.database.Product;
import com.dzejju.ordering_app.database.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements  IProductService{

    @Autowired
    private ProductRepository productRepository;

//    @Override
//    public void addProduct(String Name) {
//        productRepository.save(new Product(Name));
//    }

    @Override
    public Product getProductById(Long ID) {
        return productRepository.findById(ID).orElse(null);
    }


//    @Override
//    public int getAvailability(Product product) {
//        Stock stock = stockRepository.findById(product.getId()).orElse(null);
//        return stock.getAvailability();
//    }
}
