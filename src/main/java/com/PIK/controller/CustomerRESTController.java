package com.PIK.controller;


import com.PIK.domain.Customer;
import com.PIK.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerRESTController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRESTController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/api/customer/{id}")
    public @ResponseBody
    Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}
