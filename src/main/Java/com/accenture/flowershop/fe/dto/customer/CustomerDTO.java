package com.accenture.flowershop.fe.dto.customer;

import com.accenture.flowershop.fe.dto.cart.Cart;

import java.math.BigDecimal;

public class CustomerDTO {
    private int id;
    private String fullname;
    private String phoneNumber;
    private BigDecimal balance;
    private int discount;
    private String address;
    //у покупателя должна же быть корзина
    private Cart cart;



    public CustomerDTO() {

    }

    public CustomerDTO(int id, String fullname, String phoneNumber,
                       BigDecimal balance, int discount, String address) {
        this.id = id;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.discount = discount;
        this.address = address;
    }

    public CustomerDTO(String fullname, String phoneNumber,
                       BigDecimal balance, int discount, String address) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.discount = discount;
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public void setPhoneNumber(String phoneNumber) {
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
}
