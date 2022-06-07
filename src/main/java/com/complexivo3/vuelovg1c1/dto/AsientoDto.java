package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class AsientoDto {
    private long id;
    private String nombre;
    private double precio;
    private TipoAsientoDto tipoAsiento;
}
