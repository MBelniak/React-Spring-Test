package com.PIK.service;


import com.PIK.dao.CustomerDAO;
import com.PIK.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer getCustomerById(Long id) {
        return customerDAO.getById(id);
    }
}
