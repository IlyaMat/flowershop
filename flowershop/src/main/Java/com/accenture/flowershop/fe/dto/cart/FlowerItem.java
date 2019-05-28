package com.accenture.flowershop.fe.dto.cart;

import com.accenture.flowershop.fe.dto.product.ProductDTO;

public class FlowerItem {
    private ProductDTO product;
    private int quantityFlower;//кол-во определенного цветка

    public FlowerItem(ProductDTO product) {
        this.product = product;
    }

    public FlowerItem() {
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantityFlower() {
       return quantityFlower;
    }

    public void setQuantityFlower(int quantityFlower) {
        this.quantityFlower = quantityFlower;
    }
}
