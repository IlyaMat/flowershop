package com.accenture.flowershop.be.access.order;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.order.Order;

import java.util.List;

public interface OrderDAO {
    //поиск по id
    Order findOrderById(long orderId);

    List<Order> findOrderByCustomer(Customer customer);

    //возврат списка всех объектов
    List<Order> getAllOrders();

    //сохраняет/добавляет заказ
    void addOrder(Order order);


}
