package com.PIK.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@ToString(exclude = "vehicles")
@NoArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Please fill in 'pesel' field.")
    @Column(name = "pesel")
    private String pesel;

    @NotNull(message = "Please fill in 'first name' field.")
    @Pattern(regexp = "[\\p{L}]+$", message = "First name must only match literals")
    @Column(name = "name")
    private String firstName;

    @NotNull(message = "Please fill in 'surname' field.")
    @Pattern(regexp = "[\\p{L}]+$", message = "Surname must only match literals")
    @Column(name = "surname")
    private String surname;

    @NotNull(message = "Please fill in 'telephone' field.")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "vehicleOwner")
    private List<Vehicle> vehicles;

    @JsonCreator
    public Customer(@JsonProperty("first_name") String first_name, @JsonProperty("surname") String surname) {
        this.firstName = first_name;
        this.surname = surname;
    }

}
