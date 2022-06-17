package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VueloHoy {
    private long vueloId;
    private String destino;
    private Date fecha;
}
