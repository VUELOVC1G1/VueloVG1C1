package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.CargoDto;

import java.util.List;

public interface ICargoService {
    List<CargoDto> findAll();

    CargoDto findById(Long id);
}
