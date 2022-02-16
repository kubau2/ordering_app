package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.Cart;
import com.dzejju.ordering_app.database.CartRepository;
import com.dzejju.ordering_app.database.Customer;
import com.dzejju.ordering_app.database.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements  ICustomerService{


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void addCustomerData(Long customerId, String firstName, String lastName, String address) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer!=null) {
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customerRepository.save(customer);
        }else {
            //exception
        }
}
}
