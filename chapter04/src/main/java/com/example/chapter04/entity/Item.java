package com.example.chapter04.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuabtity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuabtity() {
        return stockQuabtity;
    }

    public void setStockQuabtity(int stockQuabtity) {
        this.stockQuabtity = stockQuabtity;
    }
}
