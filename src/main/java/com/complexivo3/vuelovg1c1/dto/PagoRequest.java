package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class PagoRequest {
    private double valor;
    private boolean estado;
    private String tipo;
}
