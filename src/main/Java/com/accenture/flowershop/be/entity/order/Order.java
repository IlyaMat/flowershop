package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.enums.Order.OrderStatus;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "_order")
@Transactional
public class Order {
    /*
     * Корзина представляет собой таблицу с данными: название цветка,
     * кол-во заказанных цветов, суммарная цена за вид цветка. Также
     * должна отображаться общая стоимость заказа в корзине, с учетом скидки.
     * Данные корзины сохраняются в сессии пользователя. Корзина отображается
     * также на главной странице пользователя.
     */

    /*
     * В заказе сохраняются суммарная цена заказа (с учетом скидки клиента),
     * дата создания заказа, дата закрытия заказа, статус заказа.
     * После создания заказ получает статус «создан» и отображается в таблице
     * заказов пользователя. Напротив заказов в статусе «создан» отображается
     * кнопка «оплатить». Таблица заказов пользователя отображается на главной
     * странице*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "total_price", precision = 8, scale = 2)
    private BigDecimal totalPrice;//общая стоимость

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;//дата создания заказа

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "closed_at")
    private Date closedAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", columnDefinition = "smallint")
    private OrderStatus status; //статус заказа(СОЗДАН, ОПЛАЧЕН, ЗАКРЫТ)

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderProduct> orderProducts;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "_order_product",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> products;

    public Order() {
    }

    public Order(Customer customer, BigDecimal totalPrice, Date createdAt, Date closedAt, OrderStatus status) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.status = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
