package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.BoletoDto;
import com.complexivo3.vuelovg1c1.dto.BoletoRequest;
import com.complexivo3.vuelovg1c1.model.Boleto;

public class BoletoMapper {

    public static Boleto toBoleto(BoletoRequest request) {
        Boleto b = new Boleto();
        b.setFecha(request.getFecha());
        b.setQr(request.getQr());
        return b;
    }

    public static BoletoDto toDto(Boleto entity) {
        BoletoDto dto = new BoletoDto();
        dto.setId(entity.getId());
        dto.setFecha(entity.getFecha());
        dto.setQr(entity.getQr());
        return dto;
    }

}
