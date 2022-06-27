package com.example.demo.service;

import com.example.demo.model.CusOrder;
import com.example.demo.model.Customer;
import com.example.demo.repository.CusOrderRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CusOrderService {
    private CusOrderRepository cusOrderRepository;

    @Autowired
    public CusOrderService(CusOrderRepository cusOrderRepository){
        this.cusOrderRepository = cusOrderRepository;
    }

    public void saveCusOrder(CusOrder cusOrder){
        cusOrderRepository.save(cusOrder);
    }

    public void deleteCusOrderById(Long id){
        cusOrderRepository.deleteById(id);
    }
}
