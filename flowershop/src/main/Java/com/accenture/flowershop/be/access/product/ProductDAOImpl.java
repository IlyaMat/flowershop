package com.accenture.flowershop.be.access.product;

import com.accenture.flowershop.be.entity.product.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Product findProductByName(String productName) {
        TypedQuery<Product> q = entityManager.createQuery(
                "select p from Product p where p.name = :name", Product.class
        );
        q.setParameter("name", productName);
        return q.getSingleResult();
    }

    @Override
    public Product findProductById(int productId) {
        TypedQuery<Product> q = entityManager.createQuery(
                "select p from Product p where p.id = :id", Product.class
        );
        q.setParameter("id", productId);
        return q.getSingleResult();
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return entityManager.createQuery(
                "select p from Product p", Product.class
        ).getResultList();
    }

    @Override
    @Transactional
    public void add(Product product) {
        entityManager.persist(product);
    }

}
