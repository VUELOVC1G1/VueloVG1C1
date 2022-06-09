package com.complexivo3.vuelovg1c1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class VueloDto {

    private Long id;
    private Date fechaCreacion;
    private Double precio;
    private String observacion;
    private Date fechaVuelo;
    private boolean estado;
    private HorarioRequest horarioRequest;
    private CharterRequest charterRequest;
    private RutaRequest rutaRequest;
}
