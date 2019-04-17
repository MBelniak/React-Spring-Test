package com.PIK.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ToString(exclude = {"vehicle","service"})
@NoArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Please fill in 'date' field.")
    @Column(name = "date")
    private Date reservationDate;

    @NotNull(message = "Please fill in 'status' field.")
    @Column(name = "status")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "fk_service_id")
    private Service service;

}
