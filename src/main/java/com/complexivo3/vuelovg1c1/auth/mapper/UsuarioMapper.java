package com.complexivo3.vuelovg1c1.auth.mapper;

import com.complexivo3.vuelovg1c1.auth.dto.*;
import com.complexivo3.vuelovg1c1.auth.model.Usuario;


import static java.util.Objects.*;

public class UsuarioMapper {

    public static Usuario loginRToUsuario(LoginRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(request.getPassword());
        return usuario;
    }

    public static UserResponse userToResponse(Usuario usuario) {
        UserResponse response = new UserResponse();
        response.setId(usuario.getId());
        response.setEmail(usuario.getCorreo());
/*
        if (nonNull(usuario.getUsuarioCharter())) {
            UCharterResponse charterResponse = new UCharterResponse();
            charterResponse.setId(usuario.getUsuarioCharter().getId());
            charterResponse.setEmpresa(usuario.getUsuarioCharter().getEmpresa());
            charterResponse.setRuc(usuario.getUsuarioCharter().getEmpresa());
        }
        if (nonNull(usuario.getPasajero())) {
            PasajeroResponse pasajeroResponse = new PasajeroResponse();
            pasajeroResponse.setId(usuario.getPasajero().getId());
            pasajeroResponse.setNombre(usuario.getPasajero().getNombre());
            pasajeroResponse.setApellido(usuario.getPasajero().getApellido());
            pasajeroResponse.setCedula(usuario.getPasajero().getCedula());
            pasajeroResponse.setFechaNacimiento(usuario.getPasajero().getFechaNacimiento());
        }
        if (nonNull(usuario.getEmpleado())) {
            EmpleadoResponse empleadoResponse = new EmpleadoResponse();
            empleadoResponse.setId(usuario.getEmpleado().getId());
            empleadoResponse.setFechaNacimiento(usuario.getEmpleado().getFechaNacimiento());
            empleadoResponse.setEstado(usuario.getEmpleado().isEstado());
            empleadoResponse.setNombre(usuario.getEmpleado().getNombre());
            empleadoResponse.setApellido(usuario.getEmpleado().getApellido());
            empleadoResponse.setCedula(usuario.getEmpleado().getCedula());
        }*/
        return response;
    }

}
