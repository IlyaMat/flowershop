package com.accenture.flowershop.fe.dto.product;

import com.accenture.flowershop.fe.dto.stock.StockDTO;

import java.math.BigDecimal;

public class ProductDTO implements Comparable<ProductDTO> {
    private int id;
    private String name;
    private BigDecimal price;
    private StockDTO stock;


    public ProductDTO() {
    }

    public ProductDTO(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int compareTo(ProductDTO product) {
        return this.getPrice().compareTo(product.getPrice());
    }
}
