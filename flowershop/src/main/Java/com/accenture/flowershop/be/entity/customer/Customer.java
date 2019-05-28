package com.accenture.flowershop.be.entity.customer;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "balance", precision = 8, scale = 2)
    private BigDecimal balance;

    @Column(name = "discount")
    private int discount;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    /*CascadeType.ALL - делаем с владеемыми объектами класса тоже самое, что и с владельцем*/
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


    public Customer() {
    }

    public Customer(String fullname, String phoneNumber, BigDecimal balance, int discount, String address) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.discount = discount;
        this.address = address;
    }

    public Customer(String fullname, String phoneNumber, BigDecimal balance, int discount, String address, User user) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.discount = discount;
        this.address = address;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone_number(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
