package com.example.mi_primera_api_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "circuits")
public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitid")
    private Long circuitid;
    @Column(unique = true, nullable = false)
    private String circuitref;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String country;
    private double lat;
    private double lng;
    private int alt;
    private String url;

    @OneToOne(mappedBy ="circuit")
    @JsonIgnoreProperties("circuit")

    private Race race;
}
