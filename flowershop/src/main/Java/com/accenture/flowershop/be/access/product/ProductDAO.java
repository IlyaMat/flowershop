package com.accenture.flowershop.be.access.product;

import com.accenture.flowershop.be.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDAO {
    //поиск цветка по названию
    Product findProductByName(String productName);

    //поиск по id
    Product findProductById(int productId);

    //возврат списка всех объектов
    List<Product> getAllProducts();

    void add(Product product);


}
