package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<CusOrder> cusOrders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, List<CusOrder> cusOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cusOrders = cusOrders;
    }

    public Long getId(Long id) {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CusOrder> getCusOrders() {
        return cusOrders;
    }

    public void setCusOrders(List<CusOrder> cusOrders) {
        this.cusOrders = cusOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cusOrders=" + cusOrders +
                '}';
    }
}
