package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.EmpleadoCargoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoCargosResponse;
import com.complexivo3.vuelovg1c1.dto.EmpleadoRequest;
import com.complexivo3.vuelovg1c1.dto.EmpleadoResponse;
import com.complexivo3.vuelovg1c1.model.Empleado;
import com.complexivo3.vuelovg1c1.model.Roles;

import java.util.stream.Collectors;

public class EmpleadoMapper {
    public static Empleado toEmpleado(EmpleadoRequest request) {
        Empleado e = new Empleado();
        e.setApellido(request.getApellido());
        e.setCedula(request.getCedula());
        e.setNombre(request.getNombre());
        e.setFechaNacimiento(request.getFechaNacimiento());
        e.setEstado(request.isEstado());
        e.setUsuario(UsuarioMapper.requestToUser(request.getUsuario()));
        e.getUsuario().setRol(Roles.EMPLEADO);
        return e;
    }

    public static Empleado toEmpleado(EmpleadoCargoRequest request) {
        Empleado e = new Empleado();
        e.setId(request.getId());
        e.setApellido(request.getApellido());
        e.setCedula(request.getCedula());
        e.setNombre(request.getNombre());
        e.setFechaNacimiento(request.getFechaNacimiento());
        e.setEstado(request.isEstado());
        e.setUsuario(UsuarioMapper.dtoToUsuario(request.getUsuario()));
        e.getCargos().add(CargoMapper.toCargo(request.getCargo()));
        e.getUsuario().setRol(Roles.EMPLEADO);
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

    public static EmpleadoCargosResponse toResponseCargo(Empleado empleado) {
        EmpleadoCargosResponse response = new EmpleadoCargosResponse();
        response.setId(empleado.getId());
        response.setApellido(empleado.getApellido());
        response.setCedula(empleado.getCedula());
        response.setNombre(empleado.getNombre());
        response.setFechaNacimiento(empleado.getFechaNacimiento());
        response.setEstado(empleado.isEstado());
        response.setUsuario(UsuarioMapper.userToResponse(empleado.getUsuario()));
        response.setCargo(empleado.getCargos()
                .stream().map(CargoMapper::toDto)
                .collect(Collectors.toList())
        );
        return response;
    }
}
