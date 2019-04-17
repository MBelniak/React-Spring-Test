package com.PIK.impl;

import com.PIK.dao.ServiceDAO;
import com.PIK.domain.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Qualifier(ServiceDAO.BEAN_NAME)
public class ServiceDAOImpl implements ServiceDAO {

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public List<Service> getAll() {
        return Arrays.asList(new Service(), new Service());
    }

    public Service getById(Long id) {
        return new Service();
    }
}
