package com.PIK.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString(exclude = "reservations")
@NoArgsConstructor
@Entity
@Table(name = "Services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Please fill in 'type name' field.")
    @Column(name = "type_name")
    private String typeName;

    @NotNull(message = "Please fill in 'price' field.")
    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "service")
    private List<Reservation> reservations;
}
