package com.example.mi_primera_api_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long resultid;

    @ManyToOne
    @JoinColumn(name = "raceid")
    Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    @JsonBackReference
    Driver driver;


    @Column(nullable = false)
    private int grid;
    @Column(name ="position")
    private Long position;
    @Column(nullable = false)
    private int points;

}
