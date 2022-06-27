package com.example.demo.Contoller;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //получение списка кастомеров с их заказами
    @GetMapping("/list")
    public List<Customer> getListCustomer(){
        List<Customer> customers = customerService.getCustomerList();
        return customers;
    }

    //добавление кастомера
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    //получение определённого кастомера с его списком заказов
    @GetMapping("/list/{id}")
    public Customer getCustomer(@PathVariable Long id){
        List<Customer> customers = customerService.getCustomerList();
        return customerService.getCustomerById(id);
    }
}
