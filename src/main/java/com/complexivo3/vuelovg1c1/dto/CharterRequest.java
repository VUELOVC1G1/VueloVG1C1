package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class CharterRequest {
    private String ruc;
    private String empresa;
    private UsuarioRequest usuario;
}
