package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.getById(id);
    }

//    public Customer findCustomerById(Long id) {
//        return customerRepository.getById(id);
//    }
}
