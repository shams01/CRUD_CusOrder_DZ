package com.example.demo.repository;

import com.example.demo.model.CusOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CusOrderRepository extends CrudRepository<CusOrder, Long> {
//    List<CusOrder> findByValue(String value);
//    CusOrder findById(long id);
}
