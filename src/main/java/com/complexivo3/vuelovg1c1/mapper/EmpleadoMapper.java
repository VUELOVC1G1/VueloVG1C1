package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.EmpleadoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
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

    public static EmpleadoResponse toResponse(Empleado empleado) {
        EmpleadoResponse response = new EmpleadoResponse();
        response.setId(empleado.getId());
        response.setApellido(empleado.getApellido());
        response.setCedula(empleado.getCedula());
        response.setNombre(empleado.getNombre());
        response.setFechaNacimiento(empleado.getFechaNacimiento());
        response.setEstado(empleado.isEstado());
        response.setUsuario(UsuarioMapper.userToResponse(empleado.getUsuario()));
        return response;
    }
}
