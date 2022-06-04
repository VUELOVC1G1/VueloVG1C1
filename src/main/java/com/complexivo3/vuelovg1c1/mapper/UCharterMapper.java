package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.CharterRequest;
import com.complexivo3.vuelovg1c1.dto.UCharterResponse;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;

public class UCharterMapper {

    public static UsuarioCharter toUCharter(CharterRequest request) {
        UsuarioCharter charter = new UsuarioCharter();
        charter.setEmpresa(request.getEmpresa());
        charter.setRuc(request.getRuc());
        charter.setUsuario(UsuarioMapper.requestToUser(request.getUsuario()));
        return charter;
    }

    public static UCharterResponse toResponse(UsuarioCharter charter) {
        UCharterResponse response = new UCharterResponse();
        response.setId(charter.getId());
        response.setEmpresa(charter.getEmpresa());
        response.setRuc(charter.getRuc());
        response.setUsuario(UsuarioMapper.userToResponse(charter.getUsuario()));
        return response;
    }
}
