package com.example.repository;

import com.example.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandEntityRepository extends JpaRepository<BrandEntity, Long> {

    Optional<BrandEntity> findByName(String name);
}
