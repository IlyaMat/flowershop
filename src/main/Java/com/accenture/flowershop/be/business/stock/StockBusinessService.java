package com.accenture.flowershop.be.business.stock;

import com.accenture.flowershop.be.entity.product.Product;

public interface StockBusinessService {

    void changeQuantityProduct(Product product, int quantity);
}
