package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class ContactoRequest {
    private String cedula;
    private String correo;
    private String nombres;
    private String apellidos;
    private String descripcion;
}
