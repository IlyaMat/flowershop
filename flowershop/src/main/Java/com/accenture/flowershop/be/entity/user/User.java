package com.accenture.flowershop.be.entity.user;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.fe.enums.User.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    /*Все пользователи имеют основные атрибуты для аутентификации:
        логин и пароль. Логин пользователя в системе должен быть уникален.
    Покупатели имеют дополнительные атрибуты: ФИО, адрес, телефон,
    денежный баланс (например, 550.05р.), скидка в % (целочисленная, например, 3%)
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role", columnDefinition = "smallint")
    private UserRole role; //роль юзера(АДМИН, ПОКУПАТЕЛЬ)

    @OneToOne(mappedBy = "user")
    private Customer customer;


    public User() {
    }

    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
