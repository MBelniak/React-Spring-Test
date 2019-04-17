package com.PIK.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/customer")
    public String getCustomerPage() {
        return "customerPage";
    }

    @RequestMapping("/vehicle")
    public String getVehiclePage() {
        return "vehiclePage";
    }
}
