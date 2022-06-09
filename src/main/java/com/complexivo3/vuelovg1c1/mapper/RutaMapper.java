package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.RutaRequest;
import com.complexivo3.vuelovg1c1.dto.RutaResponse;
import com.complexivo3.vuelovg1c1.model.Ruta;

public class RutaMapper {

    public static Ruta toRuta(RutaRequest rutaRequest){
        Ruta r = new Ruta();
        r.setId(rutaRequest.getId());
        r.setDescripcion(rutaRequest.getDescripcion());
        r.setDestino(rutaRequest.getDestino());
        r.setOrigen(rutaRequest.getOrigen());
        return r;
    }

    public static RutaResponse toRutaResponse(Ruta ruta){
        RutaResponse rutaResponse=new RutaResponse();
        rutaResponse.setId(ruta.getId());
        rutaResponse.setDescripcion(ruta.getDescripcion());
        rutaResponse.setOrigen(ruta.getOrigen());
        rutaResponse.setDestino(ruta.getDestino());
        return rutaResponse;
    }

}
