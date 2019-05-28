package com.accenture.flowershop.fe.dto.order;

import com.accenture.flowershop.fe.dto.customer.CustomerDTO;
import com.accenture.flowershop.fe.dto.orderproduct.OrderProductDTO;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import com.accenture.flowershop.fe.enums.Order.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private long id;
    private BigDecimal totalPrice;
    private Date createdAt;//дата создания заказа
    private Date closedAt;
    private OrderStatus status; //статус заказа(СОЗДАН, ОПЛАЧЕН, ЗАКРЫТ)
    private CustomerDTO customer;
    private List<ProductDTO> productList;
    private List<OrderProductDTO> orderProductList;


    public OrderDTO() {
    }

    public OrderDTO(long id, BigDecimal totalPrice, Date createdAt, Date closedAt,
                    OrderStatus status, CustomerDTO customer) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.status = status;
        this.customer = customer;
    }

    public List<OrderProductDTO> getOrderProducts() {
        return orderProductList;
    }

    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProductList = orderProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
