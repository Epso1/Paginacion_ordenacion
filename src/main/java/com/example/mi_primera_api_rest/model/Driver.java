package com.example.mi_primera_api_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true, name = "code",nullable = false)
    private String code;
    @Column(nullable = false)
    private String forename;
    @Column(nullable = false)
    private String surname;

    @JsonProperty("dateOfBirth")
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String nationality;
    private String url;

    @ManyToOne
    @JoinColumn(name = "constructorid")
    @JsonIgnoreProperties("drivers")
    @JsonBackReference
    Constructor constructor;

    @OneToMany(mappedBy = "driver")
    @JsonIgnoreProperties("driver")
    @JsonBackReference
    private Set<Result> results;
}
