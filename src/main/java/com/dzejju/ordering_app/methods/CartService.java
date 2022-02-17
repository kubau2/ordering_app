package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import com.dzejju.ordering_app.exceptions.NotEnoughProductException;
import com.dzejju.ordering_app.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements  ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Cart addToCart(Cart cart) {

        removeFromStock(cart.getProductId(),cart.getAmount());

        createCustomerIfNone(cart);
        Long customerID = cart.getCustomerID();

        //Search for this item in the database
        Cart cartOld = cartRepository.findByproductId(cart.getProductId());
        if (cartOld!=null && cartOld.getCustomerID().equals(cart.getCustomerID())){
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

    private void removeFromStock(Long productId, Integer amount){
       Stock stock = stockRepository.findById(productId).orElse(null);
       if (stock!=null){
           if (stock.getAvailability()>=amount){
               stock.setAvailability(stock.getAvailability()-amount);
           }else{
               throw new NotEnoughProductException(productId, stock.getAvailability());
           }
       }
       else{
           throw new ProductNotFoundException(productId);
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
