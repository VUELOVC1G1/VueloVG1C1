package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.VueloComercialResponse;
import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;
import com.complexivo3.vuelovg1c1.model.Vuelo;

import java.util.Date;
import java.util.Objects;

public class VueloMapper {

    public static Vuelo toVuelo(VueloRequest vueloRequest){
        Vuelo vuelo= new Vuelo();
        vuelo.setId(vueloRequest.getId());
        vuelo.setFechaCreacion(new Date(vueloRequest.getFechaCreacion().getTime()+(1000 * 60 * 60 * 24)));
        vuelo.setPrecio(vueloRequest.getPrecio());
        vuelo.setFechaVuelo(new Date(vueloRequest.getFechaVuelo().getTime()+(1000 * 60 * 60 * 24)));
        vuelo.setEstado(vueloRequest.isEstado());
        vuelo.setObservacion(vueloRequest.getObservacion());
        vuelo.setSalaEspera(vueloRequest.getSalaEspera());
        //otras entitys

        if (Objects.nonNull(vueloRequest.getUCharterResponse()))
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
        vueloResponse.setSalaEspera(vuelo.getSalaEspera());
        //otras entitys
        if (Objects.nonNull(vuelo.getUsuarioCharter()))
            vueloResponse.setUCharterResponse(UCharterMapper.toResponse(vuelo.getUsuarioCharter()));//revisar
        vueloResponse.setRutaResponse(RutaMapper.toRutaResponse(vuelo.getRuta()));
        vueloResponse.setHorarioResponse(HorarioMapper.toHorarioResponse(vuelo.getHorario()));
        vueloResponse.setTipoVueloResponse(TipoVueloMapper.toResponsoTipoVuelo(vuelo.getTipo()));
        vueloResponse.setAvionResponse(AvionMapper.toResponse(vuelo.getAvion()));
        return vueloResponse;
    }

    public static VueloComercialResponse toVueloComercialResponse(Vuelo vuelo){
        VueloComercialResponse vueloResponse=new VueloComercialResponse();
        vueloResponse.setId(vuelo.getId());
        vueloResponse.setPrecio(vuelo.getPrecio());
        vueloResponse.setFechaCreacion(vuelo.getFechaCreacion());
        vueloResponse.setFechaVuelo(vuelo.getFechaVuelo());
        vueloResponse.setEstado(vuelo.isEstado());
        vueloResponse.setSalaEspera(vuelo.getSalaEspera());
        vueloResponse.setObservacion(vuelo.getObservacion());
        //otras entitys
        vueloResponse.setRutaResponse(RutaMapper.toRutaResponse(vuelo.getRuta()));
        vueloResponse.setHorarioResponse(HorarioMapper.toHorarioResponse(vuelo.getHorario()));
        vueloResponse.setTipoVueloResponse(TipoVueloMapper.toResponsoTipoVuelo(vuelo.getTipo()));
        return vueloResponse;
    }
}
