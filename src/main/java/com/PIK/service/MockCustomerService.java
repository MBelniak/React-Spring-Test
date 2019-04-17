package com.PIK.service;

import com.PIK.dao.CustomerDAO;
import com.PIK.dao.VehicleDAO;
import com.PIK.domain.Customer;
import com.PIK.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class MockCustomerService {

    @Autowired
    @Qualifier(CustomerDAO.BEAN_NAME)
    private CustomerDAO customerDAO;

    @Autowired
    @Qualifier(VehicleDAO.BEAN_NAME)
    private VehicleDAO vehicleDAO;

    public Customer getCustomer() {
        return customerDAO.getById("1");
    }

    public Vehicle getVehicle() {
        return vehicleDAO.getById(1L);
    }
}
