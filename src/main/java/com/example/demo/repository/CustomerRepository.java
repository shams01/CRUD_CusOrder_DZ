package com.example.demo.repository;

import com.example.demo.model.CusOrder;
import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<Customer> findByLastName(String lastName);
//    Customer findById(long id);
}
