package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.PasajeroRequest;
import com.complexivo3.vuelovg1c1.dto.PasajeroResponse;
import com.complexivo3.vuelovg1c1.model.Pasajero;
import com.complexivo3.vuelovg1c1.model.Roles;

public class PasajeroMapper {

    public static Pasajero toPasajero(PasajeroRequest request) {
        Pasajero p = new Pasajero();
        p.setApellido(request.getApellido());
        p.setCedula(request.getCedula());
        p.setFechaNacimiento(request.getFechaNacimiento());
        p.setNombre(request.getNombre());
        p.setUsuario(UsuarioMapper.requestToUser(request.getUsuario()));
        p.getUsuario().setRol(Roles.PASAJERO);
        return p;
    }

    public static PasajeroResponse toResponse(Pasajero pasajero) {
        PasajeroResponse response = new PasajeroResponse();
        response.setId(pasajero.getId());
        response.setApellido(pasajero.getApellido());
        response.setCedula(pasajero.getCedula());
        response.setNombre(pasajero.getNombre());
        response.setFechaNacimiento(pasajero.getFechaNacimiento());
        response.setUsuario(UsuarioMapper.userToResponse(pasajero.getUsuario()));
        return response;
    }
}
