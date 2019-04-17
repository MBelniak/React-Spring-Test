package com.PIK.dao;

import com.PIK.domain.Reservation;

import java.util.List;

public interface ReservationDAO {
    public static String BEAN_NAME = "reservationDAO";

    List<Reservation> getAll();
    Reservation getById(Long id);
}
