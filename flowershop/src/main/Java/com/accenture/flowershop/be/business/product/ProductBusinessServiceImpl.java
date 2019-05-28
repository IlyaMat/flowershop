package com.accenture.flowershop.be.business.product;

import com.accenture.flowershop.be.access.product.ProductDAO;
import com.accenture.flowershop.be.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductBusinessServiceImpl implements ProductBusinessService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product findProductById(int productId) {
        return productDAO.findProductById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productDAO.add(product);
    }

}
