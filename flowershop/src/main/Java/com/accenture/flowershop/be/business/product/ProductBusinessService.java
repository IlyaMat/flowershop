package com.accenture.flowershop.be.business.product;

import com.accenture.flowershop.be.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductBusinessService {
    //поиск по id
    Product findProductById(int productId);

    //возврат всех цветов
    List<Product> getAllProducts();

    void addProduct(Product product);


}
