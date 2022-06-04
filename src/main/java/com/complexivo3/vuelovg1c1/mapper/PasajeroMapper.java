package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.PasajeroRequest;
import com.complexivo3.vuelovg1c1.model.Pasajero;

public class PasajeroMapper {

    public static Pasajero toPasajero(PasajeroRequest request) {
        Pasajero p = new Pasajero();
        p.setApellido(request.getApellido());
        p.setCedula(request.getCedula());
        p.setFechaNacimiento(request.getFechaNacimiento());
        p.setNombre(request.getNombre());
        p.setUsuario(UsuarioMapper.requestToUser(request.getUsuario()));
        return p;
    }
}
