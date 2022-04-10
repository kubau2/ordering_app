package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import com.dzejju.ordering_app.exceptions.DiscountCodeException;
import com.dzejju.ordering_app.exceptions.NotEnoughProductException;
import com.dzejju.ordering_app.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements  ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private DiscountCodesRepository discountCodesRepository;

    @Override
    public Cart addToCart(Cart cart) {

        String discountCode = cart.getDiscountCode();

        if(!isDiscountCodeValid(discountCode)){
            throw new DiscountCodeException();
        }

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
            cart.setDiscountCode(discountCode);
        }
        cartRepository.save(cart);
        cart = new Cart();
        cart.setCustomerID(customerID);

        updateDiscountCodeForCustomer(customerID,discountCode);

        return cart;
    }

    public void removeFromCart(Long customerID, Long ID) {
        if (customerID!=null){
            List<Cart> carts = cartRepository.findAllByCustomerID(customerID);
            for (Cart crt: carts) {
                if (crt.getProductId().equals(ID)){
                    int amount = crt.getAmount();
                    Long productID = crt.getProductId();
                    cartRepository.deleteById(crt.getId());
                    addToStock(productID, amount);
                }
            }
        }
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

    private void addToStock(Long productId, Integer amount){
        Stock stock = stockRepository.findById(productId).orElse(null);
        if (stock!=null){
                stock.setAvailability(stock.getAvailability()+amount);
                stockRepository.save(stock);
        }
        else{
            throw new ProductNotFoundException(productId);
        }
    }

    private boolean isDiscountCodeValid(String discountCode){
        if (discountCode==null){
            return true;
        }
        if (discountCodesRepository.findByCode(discountCode)==null){
            return false;
        }
        return true;
    }

    public void updateDiscountCodeForCustomer(Long customerId, String discountCode){
        List<Cart> carts = cartRepository.findAllByCustomerID(customerId);

        for (Cart cart : carts) {
            cart.setDiscountCode(discountCode);
            cartRepository.save(cart);
        }
    }


}
