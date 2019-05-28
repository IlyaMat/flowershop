package com.accenture.flowershop.be.access.stock;

import com.accenture.flowershop.be.entity.stock.Stock;

import java.util.List;

public interface StockDAO {
    //возврат списка всех объектов на складе
    List<Stock> getAllInStock();

    //Сохраняет/добавляет склад
    void addStock(Stock stock);
}
