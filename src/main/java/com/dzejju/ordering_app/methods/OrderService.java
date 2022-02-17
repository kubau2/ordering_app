package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import com.dzejju.ordering_app.exceptions.CustomerDataNotFilledException;
import com.dzejju.ordering_app.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService implements  IOrderService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public void placeOrder(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customerId != null) {

            if (customer.getFirstName()==null || customer.getLastName()==null ||customer.getAddress()==null){
                throw new CustomerDataNotFilledException(customerId);
            }

            List<Cart> itemsInCart = cartRepository.findAllByCustomerID(customerId);

            Orders orders = new Orders();
            orders.setCustomerID(customerId);
            ordersRepository.save(orders); //create order to get the ID
            Long orderID = orders.getId();
            Double cartValue = Double.valueOf(0);


            for (Cart item : itemsInCart) {
                OrderItems orderItems = new OrderItems(orderID, item.getProductId(), item.getAmount());
                orderItemsRepository.save(orderItems);

                //get the Price
                Product product = productRepository.findById(item.getProductId()).orElse(null);
                cartValue+=product.getPrice() * item.getAmount();
            }

            cartRepository.deleteAllByCustomerID(customerId);
            orders.setValue(cartValue);
            ordersRepository.save(orders);//update value of the order


        } else {
            throw new CustomerNotFoundException(customerId);
        }

    }

}
