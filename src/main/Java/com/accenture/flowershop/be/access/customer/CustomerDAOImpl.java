package com.accenture.flowershop.be.access.customer;

import com.accenture.flowershop.be.entity.customer.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer findCustomerById(int customerId) {
        TypedQuery<Customer> q = entityManager.createQuery(
                "select c from Customer c where c.id = :id", Customer.class
        );
        q.setParameter("id", customerId);
        return q.getSingleResult();
    }

    }
