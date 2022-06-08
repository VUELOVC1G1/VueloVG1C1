package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.AvionDto;
import com.complexivo3.vuelovg1c1.model.Avion;

import java.util.stream.Collectors;

public class AvionMapper {

    public static Avion toAvion(AvionDto request) {
        Avion avion = new Avion();
        avion.setId(request.getId());
        avion.setEstado(request.getEstado());
        avion.setMarca(request.getMarca());
        avion.setNombre(request.getNombre());
        avion.setModelo(request.getModelo());
        avion.setPlaca(request.getPlaca());
        avion.setWifi(request.getWifi());

        return avion;
    }

    public static Avion toAvionAsientos(AvionDto request) {
        Avion avion = new Avion();
        avion.setId(request.getId());
        avion.setEstado(request.getEstado());
        avion.setMarca(request.getMarca());
        avion.setNombre(request.getNombre());
        avion.setModelo(request.getModelo());
        avion.setPlaca(request.getPlaca());
        avion.setWifi(request.getWifi());
        avion.setAsientos(
                request.getAsientos()
                        .stream().map(AsientoMapper::toAsiento)
                        .collect(Collectors.toList())
        );

        return avion;
    }

    public static AvionDto toDto(Avion avion) {
        AvionDto dto = new AvionDto(
                avion.getId(),
                avion.getPlaca(),
                avion.getNombre(),
                avion.getEstado(),
                avion.getWifi(),
                avion.getModelo(),
                avion.getMarca()
        );
        dto.setAsientos(avion.getAsientos()
                .stream()
                .map(AsientoMapper::toDto)
                .collect(Collectors.toList()));

        return dto;
    }

}
