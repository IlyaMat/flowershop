package com.accenture.flowershop.be.access.orderproduct;

import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderProductDAOImpl implements OrderProductDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public OrderProduct findOrderProductById(long orderProductId) {
        TypedQuery<OrderProduct> q = entityManager.createQuery(
                "select op from OrderProduct where op.id = :id", OrderProduct.class
        );
        q.setParameter("id", orderProductId);
        return q.getSingleResult();
    }

    @Override
    public List<OrderProduct> getAllOrdersProducts() {
        return entityManager.createQuery(
                "select op from OrderProduct op", OrderProduct.class
        ).getResultList();
    }

    @Override
    public void addOrderProduct(OrderProduct orderProduct) {
        entityManager.persist(orderProduct);
    }

    @Override
    public List<OrderProduct> findOrderProductByOrderId(int id) {
        return entityManager.createQuery(
                "select op from OrderProduct where op.order_id = :id", OrderProduct.class)
                .setParameter("id", id).getResultList();
    }
}
