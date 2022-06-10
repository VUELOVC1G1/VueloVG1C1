package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BoletoRequest {
    private Date fecha;
    private String qr;
    private PagoRequest pago;
    private List<MaletaRequest> maletas;
    private List<AsientoDto> asientos;
    private Long pasajeroId;
}
