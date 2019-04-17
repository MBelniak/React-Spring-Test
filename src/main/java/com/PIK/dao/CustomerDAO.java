package com.PIK.dao;

import com.PIK.domain.Customer;


public interface CustomerDAO {
    public static String BEAN_NAME = "customerDAO";

    Customer getById(Long id);

    Customer getById(String id);
}
