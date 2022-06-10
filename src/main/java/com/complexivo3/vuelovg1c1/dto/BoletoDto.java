package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BoletoDto {
    private Long id;
    private Date fecha;
    private String qr;
    private PagoDto pago;
    private List<MaletaDto> maletas;
    private List<AsientoDto> asientos;
    private PasajeroResponse pasajero;
}
