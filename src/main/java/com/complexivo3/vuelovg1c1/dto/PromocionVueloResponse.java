package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class PromocionVueloResponse {
    private Long id;
    private String descripcion;
    private Integer descuento;
    private VueloResponse vuelo;
}
