package com.accenture.flowershop.be.entity.product;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.stock.Stock;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Transactional
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", precision = 6, scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Order> orders;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private Stock stock;


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
