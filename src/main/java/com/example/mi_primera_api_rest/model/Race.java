package com.example.mi_primera_api_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long raceid;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private int round;

    @OneToOne
    @JoinColumn(name = "circuitid")
    private Circuit circuit;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    private String url;

    @OneToMany(mappedBy = "race")
    @JsonIgnoreProperties("race")
    @JsonBackReference
    private Set<Result> results;
}

