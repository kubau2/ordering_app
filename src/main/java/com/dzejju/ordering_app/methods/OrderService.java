package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService implements  IOrderService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Transactional
    @Override
    public void placeOrder(Long customerId) {
        //tu sprawdz jeszcze dane klienta
        if (customerId != null) {
            List<Cart> itemsInCart = cartRepository.findAllByCustomerID(customerId);

            for (Cart item : itemsInCart) {
                //tu trzeba jeszcze ogarnac orderId
                Order order = new Order(1L, customerId, item.getProductId(), item.getAmount());
                orderRepository.save(order);
            }


            //tu leci blad, obadaj czemu
            cartRepository.deleteAllByCustomerID(customerId);

        } else {
            //exception
        }

    }
}
