package com.accenture.flowershop.be.business.stock;

import com.accenture.flowershop.be.access.stock.StockDAO;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.be.entity.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockBusinessServiceImpl implements StockBusinessService {

    @Autowired
    private StockDAO stockDAO;

    @Override
    @Transactional
    public void changeQuantityProduct(Product product, int quantity) {
        Stock stock = stockDAO.findStockByProduct(product);
        stock.setQuantity(stock.getQuantity() - quantity);
        stockDAO.addStock(stock);
    }
}
