package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CartService implements  ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Cart addToCart(Cart cart) {

        createCustomerIfNone(cart);
        Long customerID = cart.getCustomerID();

        //Search for this item in the database
        Cart cartOld = cartRepository.findByproductId(cart.getProductId());
        if (cartOld!=null){
            //if found, then update old entry
            Integer amount = cartOld.getAmount() + cart.getAmount();
            cart = cartOld;
            cart.setAmount(amount);
        }
        cartRepository.save(cart);
        cart = new Cart();
        cart.setCustomerID(customerID);
        return cart;
    }

    private void createCustomerIfNone(Cart cart){
        if (cart.getCustomerID()==null){
            Customer customer = new Customer();
            customerRepository.save(customer);
            cart.setCustomerID(customer.getId());
        }
    }


    @Override
    public String showCart(Long ID) {
        Cart cart = cartRepository.findById(ID).orElse(null);
        String concat = null;
//        for (Map.Entry<Product, Integer> set :
//                cart.getProducts().entrySet()) {
//
//            // Printing all elements of a Map
//            concat= "ID: " + cart.getId().toString() + " Product ID: " + set.getKey().getId() + " Amount: " +set.getValue() + ";";
//        }
        return concat;
    }


//    @Override
//    public int getAvailability(Product product) {
//        Stock stock = stockRepository.findById(product.getId()).orElse(null);
//        return stock.getAvailability();
//    }
}
