package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;
import com.complexivo3.vuelovg1c1.model.Promocion;

public class PromocionMapper {

    public static Promocion topromocion(PromocionRequest promocionRequest){
        Promocion prom= new Promocion();
        prom.setId(promocionRequest.getId());
        prom.setDescripcion(promocionRequest.getDescripcion());
        prom.setDescuento(promocionRequest.getDescuento());

        return prom;
    }

    public static PromocionResponse topromocionresponse(Promocion promocion){
        PromocionResponse promocionResponse = new PromocionResponse();
        promocionResponse.setId(promocion.getId());
        promocionResponse.setDescripcion(promocion.getDescripcion());
        promocionResponse.setDescuento(promocion.getDescuento());

        return promocionResponse;
    }
}
