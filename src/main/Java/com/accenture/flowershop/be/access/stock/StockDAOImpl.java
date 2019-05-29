package com.accenture.flowershop.be.access.stock;

import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.be.entity.stock.Stock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StockDAOImpl implements StockDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Stock> getAllInStock() {
        return entityManager.createQuery(
                "select s from Stock s", Stock.class
        ).getResultList();
    }

    @Override
    @Transactional
    public void addStock(Stock stock) {
        entityManager.persist(stock);
    }

    @Override
    public Stock findStockByProduct(Product product) {
        TypedQuery<Stock> q = entityManager.createQuery(
                "select s from Stock s where s.product = :product", Stock.class
        ).setParameter("product", product);
        return q.getSingleResult();
    }
}
