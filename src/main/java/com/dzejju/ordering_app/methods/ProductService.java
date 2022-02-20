package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements  IProductService{


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

//    @Override
//    public void addProduct(String Name) {
//        productRepository.save(new Product(Name));
//    }

    @Override
    public Product getProductById(Long ID) {
        return productRepository.findById(ID).orElse(null);
    }

    @Override
    public String viewProducts() {
        String concatenated = "Products:\n";

        for (Product product: productRepository.findAll()) {
           concatenated+="ID: " + product.getId() + " name: " + product.getName() + " price: " + product.getPrice() + "\n";
        }
        return concatenated;
    }

    @Override
    public String viewProductsDetails() {
        String concatenated = "Products:\n";

        for (Product product: productRepository.findAll()) {
            ProductDetails productDetails = productDetailsRepository.findById(product.getId()).orElse(null);
            concatenated+="Name: " + product.getName() + " rating: " + productDetails.getRating() + " for whom: " + productDetails.getForWhom() + "\n";
        }
        return concatenated;
    }

    @Override
    public String viewByPrice(Double price) {
        String concatenated = "Products by Price:\n";

        for (Product product: productRepository.findAllByPrice(price)) {
            concatenated+="Name: " + product.getName() + " price: " + product.getPrice() + "\n";
        }
        return concatenated;
    }

    @Override
    public String viewByTags(String tags) {
        String concatenated = "Products by Tag:\n";
        String[] parts = tags.split("#");

        for (String tag: parts) {
            if (tag.equals("")){
                continue;
            }
            for (Product product: productRepository.findAll()) {
                if (product.getTags().contains(tag)){
                    concatenated+="Name: " + product.getName() + " price: " + product.getPrice() + "\n";
                }
            }
        }
        return concatenated;
    }

}
