package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.TipoVueloRequest;
import com.complexivo3.vuelovg1c1.dto.TipoVueloResponse;
import com.complexivo3.vuelovg1c1.model.TipoVuelo;

public class TipoVueloMapper {

    public static TipoVuelo toTipoVuelo(TipoVueloRequest vueloRequest){
        TipoVuelo tp=new TipoVuelo();
        tp.setId(vueloRequest.getId());
        tp.setNombre(vueloRequest.getNombre());
        return tp;
    }

    public static TipoVueloResponse toResponsoTipoVuelo(TipoVuelo tipoVuelo){
        TipoVueloResponse tipovueloResponse=new TipoVueloResponse();
        tipovueloResponse.setId(tipoVuelo.getId());
        tipovueloResponse.setNombre(tipoVuelo.getNombre());
        return  tipovueloResponse;
    }
}
