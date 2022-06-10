package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;

public interface IPromocionService {

    PromocionResponse findByPromocionId(Long id);
    void guardarPromocion(PromocionRequest promocionRequest);
    PromocionResponse deltevyIdPromocion(Long id);
    Boolean updatePromocion(PromocionRequest promocionRequest);
}
