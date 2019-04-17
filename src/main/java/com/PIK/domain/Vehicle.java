package com.PIK.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@ToString(exclude = {"vehicleOwner","reservation"})
@NoArgsConstructor
@Entity
@Table(name="Vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Please fill in 'registration_plate' field.")
    @Column(name="registration_plate")
    private String registrationPlate;

    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private Customer vehicleOwner;

    @OneToOne(mappedBy = "vehicle")
    private Reservation reservation;
}
