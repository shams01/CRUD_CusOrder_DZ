package com.example.demo.Contoller;

import com.example.demo.model.CusOrder;
import com.example.demo.service.CusOrderService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cusOrder")
public class CusOrderController {
    private CustomerService customerService;
    private CusOrderService cusOrderService;

    @Autowired
    public CusOrderController(CustomerService customerService, CusOrderService cusOrderService) {
        this.customerService = customerService;
        this.cusOrderService = cusOrderService;
    }

    //добавление заказа определённого кастомера
    @PostMapping("/addCusOrder/{id}")
    public void addCusOrder(@PathVariable Long id, @RequestBody CusOrder cusOrder) {
        cusOrder.setCustomer(customerService.getCustomerById(id));
        cusOrderService.saveCusOrder(cusOrder);
    }

    //удаление определённого заказа
    @GetMapping("/deleteCusOrder/{id}")
    public void deleteCusOrder(@PathVariable Long id){
        cusOrderService.deleteCusOrderById(id);
    }
}
