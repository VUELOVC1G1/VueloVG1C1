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

    public AvionDto(Long id, String placa, String nombre, Boolean estado, String wifi, String modelo, String marca) {
        this.id = id;
        this.placa = placa;
        this.nombre = nombre;
        this.estado = estado;
        this.wifi = wifi;
        this.modelo = modelo;
        this.marca = marca;
    }
}
