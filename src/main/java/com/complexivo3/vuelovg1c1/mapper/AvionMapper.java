package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.AvionDto;
import com.complexivo3.vuelovg1c1.dto.AvionRequest;
import com.complexivo3.vuelovg1c1.dto.AvionResponse;
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


    /** ---------------------------------------- MÉTODOS PROPUESTOS PARA ESTE SERVICIO ---------------------------------------- 
     * @author Eduardo Mendieta
    */
    public static Avion toAvion(AvionRequest request){
        Avion avion = new Avion();
        avion.setEstado(request.getEstado());
        avion.setMarca(request.getMarca());
        avion.setModelo(request.getModelo());
        avion.setNombre(request.getNombre());
        avion.setPlaca(request.getPlaca());
        avion.setWifi(request.getWifi());
        return avion;
    }

    public static AvionResponse toResponse(Avion avion){
        AvionResponse response  = new AvionResponse();
        response.setEstado(avion.getEstado());
        response.setId(avion.getId());
        response.setMarca(avion.getMarca());
        response.setModelo(avion.getModelo());
        response.setNombre(avion.getNombre());
        response.setPlaca(avion.getPlaca());
        response.setWifi(avion.getWifi());
        return response;
    }

}
