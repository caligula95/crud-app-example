package com.example.service.impl;

import com.example.dto.CarDTO;
import com.example.entity.BrandEntity;
import com.example.entity.CarEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.CarMapper;
import com.example.repository.BrandEntityRepository;
import com.example.repository.CarEntityRepository;
import com.example.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarEntityRepository carEntityRepository;
    private final BrandEntityRepository brandEntityRepository;
    private final CarMapper carMapper;

    @Override
    public void save(CarDTO carDTO) {
        CarEntity carEntity = carMapper.fromCarDTOToCarEntity(carDTO);
        BrandEntity brandEntity = brandEntityRepository.findByName(carDTO.brand())
                .orElse(new BrandEntity(carDTO.brand()));
        carEntity.setBrand(brandEntity);

        carEntityRepository.save(carEntity);
    }

    @Override
    public List<CarDTO> findAll() {
        return carEntityRepository.findAll().stream()
                .map(carMapper::fromCarEntityToCarDTO)
                .toList();
    }

    @Override
    public CarDTO findById(Long id) {
        return carMapper.fromCarEntityToCarDTO(carEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found by id " + id)));
    }

    @Override
    public void delete(Long id) {
        carEntityRepository.deleteById(id);
    }
}
