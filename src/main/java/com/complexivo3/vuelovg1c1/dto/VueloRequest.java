package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VueloRequest {
    private Long id;
    private Date fechaCreacion;
    private Double precio;
    private String observacion;
    private Date fechaVuelo;
    private boolean estado;
    private HorarioRequest horarioRequest;
    private UCharterResponse uCharterResponse;
    private RutaRequest rutaRequest;
    private TipoVueloRequest tipoVueloRequest;
}
