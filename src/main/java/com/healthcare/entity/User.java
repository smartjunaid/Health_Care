package com.healthcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "city_name", referencedColumnName = "name")
    private City city;

    @ManyToOne
    @JoinColumn(name = "state_name", referencedColumnName = "name")
    private State state;

    @ManyToOne
    @JoinColumn(name = "country_name", referencedColumnName = "name")
    private Country country;
}
