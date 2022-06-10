package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.ManifiestoRequest;
import com.complexivo3.vuelovg1c1.dto.ManifiestoResponse;
import com.complexivo3.vuelovg1c1.model.Manifiesto;

public class ManifiestoMapper {
    public static ManifiestoResponse toResponse(Manifiesto manifiesto){
        ManifiestoResponse response = new ManifiestoResponse();
        response.setCharterResponse(UCharterMapper.toResponse(manifiesto.getUsuarioCharter()));
        response.setDocumento(manifiesto.getDocumento());
        response.setId(manifiesto.getId());
        return response;
    }

    public static Manifiesto toManifiesto(ManifiestoRequest request){
        Manifiesto manifiesto = new Manifiesto();
        manifiesto.setDocumento(request.getDocumento());
        manifiesto.setUsuarioCharter(UCharterMapper.toUCharter(request.getCharterRequest()));
        return manifiesto;
    }
}
