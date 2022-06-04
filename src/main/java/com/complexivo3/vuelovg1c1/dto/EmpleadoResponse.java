package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmpleadoResponse {
    private long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private boolean estado;
}
