package com.complexivo3.vuelovg1c1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactoDto {
    private Long id;
    private String cedula;
    private String correo;
    private String nombres;
    private String apellidos;
    private String descripcion;
    private Date fecha;
}
