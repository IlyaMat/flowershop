package com.accenture.flowershop.be.business.customer;

import com.accenture.flowershop.be.entity.customer.Customer;

public interface CustomerBusinessService {
    //поиск по id
    Customer findCustomerById(int customerId);
}
