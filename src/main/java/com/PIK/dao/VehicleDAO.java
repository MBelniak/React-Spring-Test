package com.PIK.dao;

import com.PIK.domain.Vehicle;

import java.util.List;

public interface VehicleDAO {
    public static String BEAN_NAME = "vehicleDAO";

    List<Vehicle> getAll();
    Vehicle getById(Long id);
}
