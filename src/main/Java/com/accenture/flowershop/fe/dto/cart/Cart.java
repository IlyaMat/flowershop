package com.accenture.flowershop.fe.dto.cart;

import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.dto.product.ProductDTO;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {
    private HashMap<Integer, FlowerItem> basketGoods;
    private int totalQuantityProducts;//кол-во цветов в корзине всего/прибавляется всегда
    //private int quantityFlower;//кол-во определенного цветка
    //не, для этого над создать класс
    private BigDecimal totalPrice;//без учета скидки
    private BigDecimal totalPriceWithDiscount;//с учетом скидки
    private int customerDiscount;//должна быть установлена


    public Cart() {
        basketGoods = new HashMap<>();
    }


    public void addToCart(ProductDTO product) {
        if (basketGoods.containsKey(product.getId())) {
            FlowerItem flowerItem = basketGoods.get(product.getId());
            flowerItem.setQuantityFlower(flowerItem.getQuantityFlower() + 1);
            setQuantityProducts(getTotalQuantityProducts() + 1);
        } else {
            FlowerItem flowerItem = new FlowerItem(product);
            basketGoods.put(flowerItem.getProduct().getId(), flowerItem);
            flowerItem.setQuantityFlower(flowerItem.getQuantityFlower() + 1);
            setQuantityProducts(getTotalQuantityProducts() + 1);
        }
        calculateTotalPrice();
    }

    //цена за все
    public void calculateTotalPrice() {
        //totalPrice = BigDecimal.valueOf(0);
        BigDecimal total = new BigDecimal(0);//с этим и будем складывать
        for (FlowerItem item : basketGoods.values()) {
            int quantity = item.getQuantityFlower();
            BigDecimal price = item.getProduct().getPrice();
            BigDecimal res = price.multiply(new BigDecimal(quantity));

            total = total.add(res);
        }
        //System.out.println(total);
        this.setTotalPrice(total);

        if (customerDiscount != 0) {
            BigDecimal discount = total.multiply(new BigDecimal(customerDiscount)).divide(new BigDecimal(100));
            this.setTotalPriceWithDiscount(total.subtract(discount));

        }
    }

    public int getDiscount() {
        return customerDiscount;
    }

    public void setDiscount(int customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    public BigDecimal getTotalPriceWithDiscount() {
        return totalPriceWithDiscount;
    }

    public void setTotalPriceWithDiscount(BigDecimal totalPriceWithDiscount) {
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }

    public HashMap<Integer, FlowerItem> getBasketGoods() {
        return basketGoods;
    }

    public void setTotalQuantityProducts(int totalQuantityProducts) {
        this.totalQuantityProducts = totalQuantityProducts;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setBasketGoods(HashMap<Integer, FlowerItem> basketGoods) {
        this.basketGoods = basketGoods;
    }

    public int getTotalQuantityProducts() {
        return totalQuantityProducts;
    }

    public void setQuantityProducts(int totalQuantityProducts) {
        this.totalQuantityProducts = totalQuantityProducts;
    }
}
