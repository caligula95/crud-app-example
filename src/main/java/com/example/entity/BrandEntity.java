package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    private String name;

    public BrandEntity(String name) {
        this.name = name;
    }
}
