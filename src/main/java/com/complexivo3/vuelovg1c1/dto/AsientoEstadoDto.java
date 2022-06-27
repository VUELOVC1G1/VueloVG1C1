package com.complexivo3.vuelovg1c1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AsientoEstadoDto {
    private long id;
    private String nombre;
    private double precio;
    private TipoAsientoDto tipoAsiento;
    private boolean estado;
}
