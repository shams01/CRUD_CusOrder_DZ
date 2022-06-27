package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;

@Entity
public class CusOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value")
    private String value;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
//    private Date date = new Date(new Timestamp(System.currentTimeMillis()).getTime());
    private String date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    public CusOrder(){}

    public CusOrder(String value, String comment, String date, Customer customer) {
        this.value = value;
        this.comment = comment;
        this.date = date;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return String.format("CusOrder[id='%d', value='%s', comment='%s', date='%s', customer='%s']",
                id, value, comment, date, customer);
    }

//    @Override
//    public String toString() {
//        return String.format("CusOrder[id='%d', value='%s', comment='%s', date='%s']",
//                id, value, comment, date);
//    }
}
