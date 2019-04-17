package com.PIK.impl;

import com.PIK.dao.VehicleDAO;
import com.PIK.domain.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Qualifier(VehicleDAO.BEAN_NAME)
public class VehicleDAOImpl implements VehicleDAO {

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public List<Vehicle> getAll() {
        return Arrays.asList(new Vehicle(), new Vehicle());
    }

    public Vehicle getById(Long id) {
        return (Vehicle) this.getSession()
                .createCriteria(Vehicle.class)
                .add(Restrictions.eq("id", id.intValue()))
                .uniqueResult();
    }
}
