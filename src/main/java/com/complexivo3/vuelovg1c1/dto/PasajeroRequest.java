package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PasajeroRequest {
    private String cedula;
    private Date fechaNacimiento;
    private String nombre;
    private String apellido;
    private UsuarioRequest usuario;
}
