package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.TipoVueloRequest;
import com.complexivo3.vuelovg1c1.dto.TipoVueloResponse;

public interface ITipoVueloService {

    TipoVueloResponse findBytipovueloId(Long id);
    TipoVueloResponse guardartipovuelo(TipoVueloRequest tipoVueloRequest);
    TipoVueloResponse deltevyIdtipovuelo(Long id);
    Boolean updatetipovuelo(TipoVueloRequest tipoVueloRequest);
}
