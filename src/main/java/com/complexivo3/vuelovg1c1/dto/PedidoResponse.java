package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;
@Data
public class PedidoResponse {
    private Long id;
    private boolean estado;
    private String ruta;
    private Date fecha;
}
