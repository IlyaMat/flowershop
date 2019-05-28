package com.accenture.flowershop.be.business.customer;

import com.accenture.flowershop.be.access.customer.CustomerDAO;
import com.accenture.flowershop.be.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer findCustomerById(int customerId) {
       return customerDAO.findCustomerById(customerId);
    }
}
