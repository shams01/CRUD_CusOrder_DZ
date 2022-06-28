package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

    @Async
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.getById(id);
    }
}
