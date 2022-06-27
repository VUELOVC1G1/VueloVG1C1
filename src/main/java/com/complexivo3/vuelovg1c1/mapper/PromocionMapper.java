package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;
import com.complexivo3.vuelovg1c1.dto.PromocionVueloComercialResponse;
import com.complexivo3.vuelovg1c1.dto.PromocionVueloResponse;
import com.complexivo3.vuelovg1c1.model.Promocion;

public class PromocionMapper {

    public static Promocion topromocion(PromocionRequest promocionRequest){
        Promocion prom= new Promocion();
        prom.setId(promocionRequest.getId());
        prom.setDescripcion(promocionRequest.getDescripcion());
        prom.setDescuento(promocionRequest.getDescuento());

        return prom;
    }

    public static PromocionResponse topromocionresponsedelete(Promocion promocion){
        PromocionResponse promocionResponse = new PromocionResponse();
        promocionResponse.setId(promocion.getId());
        promocionResponse.setDescripcion(promocion.getDescripcion());
        promocionResponse.setDescuento(promocion.getDescuento());

        return promocionResponse;
    }

    public static PromocionVueloResponse topromocionresponse(Promocion promocion){
        PromocionVueloResponse promocionResponse = new PromocionVueloResponse();
        promocionResponse.setId(promocion.getId());
        promocionResponse.setDescripcion(promocion.getDescripcion());
        promocionResponse.setDescuento(promocion.getDescuento());
        promocionResponse.setVuelo(VueloMapper.toVueloResponse(promocion.getVuelo()));

        return promocionResponse;
    }

    public static PromocionVueloComercialResponse topromocionresponsecomercial(Promocion promocion){
        PromocionVueloComercialResponse promocionResponse = new PromocionVueloComercialResponse();
        promocionResponse.setId(promocion.getId());
        promocionResponse.setDescripcion(promocion.getDescripcion());
        promocionResponse.setDescuento(promocion.getDescuento());
        promocionResponse.setVuelo(VueloMapper.toVueloComercialResponse(promocion.getVuelo()));

        return promocionResponse;
    }
}
