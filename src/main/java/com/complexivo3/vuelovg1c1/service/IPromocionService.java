package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;
import com.complexivo3.vuelovg1c1.dto.PromocionVueloComercialResponse;
import com.complexivo3.vuelovg1c1.dto.PromocionVueloResponse;

import java.util.List;

public interface IPromocionService {

    PromocionVueloResponse findByPromocionId(Long id);
    void guardarPromocion(PromocionRequest promocionRequest);
    PromocionResponse deltevyIdPromocion(Long id);
    Boolean updatePromocion(PromocionRequest promocionRequest);

    List<PromocionVueloResponse> findAll();

    List<PromocionVueloComercialResponse> findAllComerciales();

    List<PromocionVueloResponse> findAllCharter();

    List<PromocionResponse> findVueloPromociones(Long id);
}
