package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.fe.dto.order.OrderDTO;

import java.util.List;

public interface OrderBusinessService {
    /*
    * При нажатии на кнопку «оплатить» должна происходить оплата заказа:
    * проверяется достаточно ли средств и покупателя для оплаты, списываются
    * средства со счета, заказ переходит в статус «оплачен».
    После успешной аутентификации администратор попадает на основную
    * администраторскую страницу приложения. На ней отображаются все заказы
    * пользователей с сортировкой по дате создания и статусу.
    Напротив заказов в статусе «оплачен» отображается кнопка «закрыть».
    * Администратор закрывает заказы после того, как они были доставлены клиенту.
    */


    void createOrder(OrderDTO orderDTO);

    void addOrder(Order order);

    //тут оплатим и изменим статус заказа
    Order payOrder(long orderId);

    Order closeOrder(long orderId);//для админа

    Order findOrderById(long id);

    List<Order> getAllOrders();

    List<Order> findOrderByCustomer(Customer customer);
}
