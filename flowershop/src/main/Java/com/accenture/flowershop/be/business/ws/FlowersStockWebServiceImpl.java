package com.accenture.flowershop.be.business.ws;

import com.accenture.flowershop.be.access.stock.StockDAO;
import com.accenture.flowershop.be.entity.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;

@Service("flowersStockWebService")
@WebService(endpointInterface = "com.accenture.flowershop.be.business.ws.FlowerStockService")
public class FlowersStockWebServiceImpl implements FlowersStockWebService{

    @Autowired
    private StockDAO stockDAO;

    @Override
    @Transactional
    public void increaseFlowersStockSize(int count) {
        List<Stock> stocks = stockDAO.getAllInStock();
        for (Stock stock : stocks) {
            //получаем значение каждого и увеличиваем на count
            stock.setQuantity(stock.getQuantity() + count);
            //и сохраняем
            stockDAO.addStock(stock);
        }

    }
}
