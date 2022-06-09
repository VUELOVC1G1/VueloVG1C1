package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;
import com.complexivo3.vuelovg1c1.model.Vuelo;

public interface IVueloService {
    VueloResponse findByVueloId(Long id);
    void guardarVuelo(VueloRequest vueloRequest);
    VueloResponse deltevyIdVuelo(Long id);
    Boolean updateVuelo(VueloRequest vueloRequest);
}
