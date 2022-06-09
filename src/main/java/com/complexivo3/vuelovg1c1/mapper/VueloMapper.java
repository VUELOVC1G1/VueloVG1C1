package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;
import com.complexivo3.vuelovg1c1.model.Vuelo;

public class VueloMapper {

    public static Vuelo toVuelo(VueloRequest vueloRequest){
        Vuelo vuelo= new Vuelo();
        vuelo.setId(vueloRequest.getId());
        vuelo.setFechaCreacion(vueloRequest.getFechaCreacion());
        vuelo.setPrecio(vueloRequest.getPrecio());
        vuelo.setFechaVuelo(vueloRequest.getFechaVuelo());
        vuelo.setEstado(vueloRequest.isEstado());
        vuelo.setObservacion(vueloRequest.getObservacion());
        //otras entitys

        vuelo.setUsuarioCharter(UCharterMapper.toUCharter2(vueloRequest.getUCharterResponse()));
        vuelo.setRuta(RutaMapper.toRuta(vueloRequest.getRutaRequest()));
        vuelo.setHorario(HorarioMapper.toHorario(vueloRequest.getHorarioRequest()));
        vuelo.setTipo(TipoVueloMapper.toTipoVuelo(vueloRequest.getTipoVueloRequest()));


        return vuelo;
    }

    public static VueloResponse toVueloResponse(Vuelo vuelo){
        VueloResponse vueloResponse=new VueloResponse();
        vueloResponse.setId(vuelo.getId());
        vueloResponse.setPrecio(vuelo.getPrecio());
        vueloResponse.setFechaCreacion(vuelo.getFechaCreacion());
        vueloResponse.setFechaVuelo(vuelo.getFechaVuelo());
        vueloResponse.setEstado(vuelo.isEstado());
        vueloResponse.setObservacion(vuelo.getObservacion());
        //otras entitys
        vueloResponse.setUCharterResponse(UCharterMapper.toResponse(vuelo.getUsuarioCharter()));//revisar
        vueloResponse.setRutaResponse(RutaMapper.toRutaResponse(vuelo.getRuta()));
        vueloResponse.setHorarioResponse(HorarioMapper.toHorarioResponse(vuelo.getHorario()));
        vueloResponse.setTipoVueloResponse(TipoVueloMapper.toResponsoTipoVuelo(vuelo.getTipo()));
        return vueloResponse;
    }
}
