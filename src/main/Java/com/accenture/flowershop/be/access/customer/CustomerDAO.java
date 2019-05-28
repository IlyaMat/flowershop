package com.accenture.flowershop.be.access.customer;

import com.accenture.flowershop.be.entity.customer.Customer;

public interface CustomerDAO {
    //Сохраняет/добавляет покупателя
    void addCustomer(Customer customer);

    //поиск покупателя по id
    Customer findCustomerById(int customerId);
}
