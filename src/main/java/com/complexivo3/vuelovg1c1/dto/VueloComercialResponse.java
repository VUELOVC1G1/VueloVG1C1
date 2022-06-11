package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VueloComercialResponse {
    private Long id;
    private Date fechaCreacion;
    private Double precio;
    private String observacion;
    private Date fechaVuelo;
    private boolean estado;
    private HorarioResponse horarioResponse;
    private RutaResponse rutaResponse;
    private TipoVueloResponse tipoVueloResponse;
}
