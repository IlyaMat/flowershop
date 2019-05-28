package com.accenture.flowershop.fe.dto.stock;

import com.accenture.flowershop.fe.dto.product.ProductDTO;

public class StockDTO {
    private long id;
    private ProductDTO product;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDTO getProductDTO() {
        return product;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.product = productDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
