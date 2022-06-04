package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class UCharterResponse {
    private long id;
    private String ruc;
    private String empresa;
    private UserResponse usuario;
}