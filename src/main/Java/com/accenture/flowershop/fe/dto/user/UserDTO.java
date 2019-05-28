package com.accenture.flowershop.fe.dto.user;

import com.accenture.flowershop.fe.dto.customer.CustomerDTO;
import com.accenture.flowershop.fe.enums.User.UserRole;

public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private UserRole userRole;
    private CustomerDTO customer;

    public UserDTO() {
    }

    public UserDTO(long id, String username, String password, String email,
                   UserRole userRole, CustomerDTO customer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        this.customer = customer;
    }

    public UserDTO(String username, String password, String email,
                   UserRole userRole, CustomerDTO customer) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
