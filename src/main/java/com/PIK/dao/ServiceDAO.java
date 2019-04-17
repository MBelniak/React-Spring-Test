package com.PIK.dao;

import com.PIK.domain.Service;

import java.util.List;

public interface ServiceDAO {
    public static String BEAN_NAME = "serviceDAO";

    List<Service> getAll();
    Service getById(Long id);
}
