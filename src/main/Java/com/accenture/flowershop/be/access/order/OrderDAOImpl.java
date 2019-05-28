package com.accenture.flowershop.be.access.order;

import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.order.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Order findOrderById(long orderId) {
        TypedQuery<Order> q = entityManager.createQuery(
                "select o from Order o where o.id = :id",Order.class
        );
        q.setParameter("id",orderId);
        return q.getSingleResult();
    }

    @Override
    public List<Order> findOrderByCustomer(Customer customer) {
        TypedQuery<Order> q = entityManager.createQuery(
                "select o from Order o where o.customer = :customer", Order.class);
        q.setParameter("customer", customer);
        return q.getResultList();
    }

    @Override
    public List<Order> getAllOrders() {
      return entityManager.createQuery(
                "select o from Order o",Order.class
        ).getResultList();
    }

    @Override
    public void addOrder(Order order) {
        entityManager.persist(order);
    }
}
