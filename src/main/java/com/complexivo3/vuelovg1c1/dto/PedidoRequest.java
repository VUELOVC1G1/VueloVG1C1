package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PedidoRequest {
    private Long id;
    private boolean estado;
    private String ruta;
    private Date fecha;
    private Long id_charter;
}
