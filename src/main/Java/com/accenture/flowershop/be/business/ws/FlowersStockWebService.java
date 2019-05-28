package com.accenture.flowershop.be.business.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FlowersStockWebService {

    void increaseFlowersStockSize(@WebParam(name = "count") int count);
}
