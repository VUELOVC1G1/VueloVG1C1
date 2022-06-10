package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class PromocionRequest {
    private Long id;
    private Long vueloid;
    private String descripcion;
    private Integer descuento;

}
