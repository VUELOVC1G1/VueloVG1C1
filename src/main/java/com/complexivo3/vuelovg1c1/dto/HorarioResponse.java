package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HorarioResponse {
    private Long id;
    private Date fechaInicio;
    private Date fechaFin;
}
