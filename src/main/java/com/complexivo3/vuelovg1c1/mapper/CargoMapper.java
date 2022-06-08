package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.CargoDto;
import com.complexivo3.vuelovg1c1.dto.CargoRequest;
import com.complexivo3.vuelovg1c1.model.Cargo;

public class CargoMapper {

    public static Cargo toCargo(CargoRequest request) {
        Cargo c = new Cargo();
        c.setNombre(request.getNombre());
        return c;
    }

    public static Cargo toCargo(CargoDto request) {
        Cargo c = new Cargo();
        c.setId(request.getId());
        c.setNombre(request.getNombre());
        c.setSiglas(request.getSiglas());
        return c;
    }

    public static CargoDto toDto(Cargo entity) {
        return new CargoDto(entity.getId(), entity.getNombre(), entity.getSiglas());
    }
}
