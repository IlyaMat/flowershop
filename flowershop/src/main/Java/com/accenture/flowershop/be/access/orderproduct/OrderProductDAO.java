package com.accenture.flowershop.be.access.orderproduct;

import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;

import java.util.List;

public interface OrderProductDAO {
    //поиск по id
    OrderProduct findOrderProductById(long orderProductId);

    //возврат списка всех объектов
    List<OrderProduct> getAllOrdersProducts();

    //сохраняет/добавляет OrderProduct
    void addOrderProduct(OrderProduct orderProduct);

    List<OrderProduct> findOrderProductByOrderId(int id);
}
