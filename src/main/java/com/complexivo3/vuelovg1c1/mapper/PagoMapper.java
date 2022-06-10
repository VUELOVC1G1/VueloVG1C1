package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.PagoDto;
import com.complexivo3.vuelovg1c1.dto.PagoRequest;
import com.complexivo3.vuelovg1c1.model.Pago;

public class PagoMapper {

    public static Pago toPago(PagoRequest request) {
        Pago p = new Pago();
        p.setEstado_pago(request.isEstado());
        p.setValor_pago(request.getValor());
        p.setTipo(request.getTipo());
        return p;
    }

    public static PagoDto toDto(Pago pago) {
        PagoDto dto = new PagoDto();
        dto.setId(pago.getId());
        dto.setEstado(pago.getEstado_pago());
        dto.setValor(pago.getValor_pago());
        dto.setTipo(pago.getTipo());
        return dto;
    }
}
