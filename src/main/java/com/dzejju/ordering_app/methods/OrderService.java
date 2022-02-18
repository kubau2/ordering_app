package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.*;
import com.dzejju.ordering_app.exceptions.CustomerDataNotFilledException;
import com.dzejju.ordering_app.exceptions.CustomerNotFoundException;
import org.hibernate.internal.util.MathHelper;
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

    @Autowired
    private DiscountCodesRepository discountCodesRepository;

    @Transactional
    @Override
    public void placeOrder(Long customerId) {

        if (customerId != null) {
            Customer customer = customerRepository.findById(customerId).orElse(null);

            if (customer.getFirstName()==null || customer.getLastName()==null ||customer.getAddress()==null){
                throw new CustomerDataNotFilledException(customerId);
            }

            List<Cart> itemsInCart = cartRepository.findAllByCustomerID(customerId);

            Orders orders = new Orders();
            orders.setCustomerID(customerId);
            orders.setDiscountCode(itemsInCart.get(0).getDiscountCode());
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

            //Calculate discount from code
            if(itemsInCart.get(0).getDiscountCode()!=null){
                Long discountValue = discountCodesRepository.findByCode(itemsInCart.get(0).getDiscountCode()).getDiscountPercent();
                cartValue= (cartValue*discountValue)/100;
            }

            cartRepository.deleteAllByCustomerID(customerId);
            orders.setValue(cartValue);
            ordersRepository.save(orders);//update value of the order


        } else {
            throw new CustomerNotFoundException(customerId);
        }

    }

}
