package com.PIK.impl;

import com.PIK.dao.ReservationDAO;
import com.PIK.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Qualifier(ReservationDAO.BEAN_NAME)
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public List<Reservation> getAll() {
        return Arrays.asList(new Reservation(), new Reservation());
    }

    public Reservation getById(Long id) {
        return new Reservation();
    }
}
