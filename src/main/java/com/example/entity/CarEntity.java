package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car_table")
@Data
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private BrandEntity brand;
}
