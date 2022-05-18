package com.alfred.hellospringwebapp.service;

import com.alfred.hellospringwebapp.dao.CustomerDao;
import com.alfred.hellospringwebapp.exception.CustomerNotFoundException;
import com.alfred.hellospringwebapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    private List<Customer> customerList = new CopyOnWriteArrayList<>();
    private int customerIdCount = 1;

    @Autowired
    private CustomerDao customerDao;

    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer record is not available");

        return optionalCustomer.get();
    }

    public Customer updateCustomer (int customerId, Customer customer) {

        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

    public void deleteCustomer (int customerId) {

        customerDao.deleteById(customerId);

    }

}
