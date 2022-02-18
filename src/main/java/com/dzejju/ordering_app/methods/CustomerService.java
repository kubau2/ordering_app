package com.dzejju.ordering_app.methods;

import com.dzejju.ordering_app.database.Cart;
import com.dzejju.ordering_app.database.CartRepository;
import com.dzejju.ordering_app.database.Customer;
import com.dzejju.ordering_app.database.CustomerRepository;
import com.dzejju.ordering_app.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements  ICustomerService{


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void addCustomerData(Long customerId, String firstName, String lastName, String address) {
        if (customerId!=null) {
            Customer customer = customerRepository.findById(customerId).orElse(null);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customerRepository.save(customer);
        }else {
            throw new CustomerNotFoundException(customerId);
        }
}

    @Override
    public Long createCustomer(String firstName, String lastName, String address) {
        Customer customer = new Customer(firstName, lastName, address);
        customerRepository.save(customer);
        return customer.getId();
    }
}
