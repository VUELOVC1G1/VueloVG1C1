package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.EmpleadoRequest;
import com.complexivo3.vuelovg1c1.model.Empleado;

public class EmpleadoMapper {
    public static Empleado toEmpleado(EmpleadoRequest request) {
        Empleado e = new Empleado();
        e.setApellido(request.getApellido());
        e.setCedula(request.getCedula());
        e.setNombre(request.getNombre());
        e.setFechaNacimiento(request.getFechaNacimiento());
        e.setEstado(request.isEstado());
        e.setUsuario(UsuarioMapper.requestToUser(request.getUsuario()));
        return e;
    }
}
