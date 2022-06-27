package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.CargoDto;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.CargoMapper;
import com.complexivo3.vuelovg1c1.model.Cargo;
import com.complexivo3.vuelovg1c1.repository.ICargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CargoService implements ICargoService {

    private final ICargoRepository cargoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CargoDto> findAll() {
        return cargoRepository.findAll()
                .stream().map(CargoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public CargoDto findById(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un cargo con id: " + id));
        return CargoMapper.toDto(cargo);
    }
}
