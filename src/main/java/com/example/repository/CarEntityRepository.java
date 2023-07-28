package com.example.repository;

import com.example.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarEntityRepository extends JpaRepository<CarEntity, Long> {
}
