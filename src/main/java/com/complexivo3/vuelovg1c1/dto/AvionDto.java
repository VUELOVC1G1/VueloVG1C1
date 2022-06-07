package com.complexivo3.vuelovg1c1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvionDto {
    private Long id;
    private String placa;
    private String nombre;
    private Boolean estado;
    private String wifi;
    private String modelo;
    private String marca;
    private List<AsientoDto> asientos;
}
