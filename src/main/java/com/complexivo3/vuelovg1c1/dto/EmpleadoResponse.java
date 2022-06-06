package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EmpleadoResponse {
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private boolean estado;
    private UserDto usuario;
    private List<CargoDto> cargo;
}
