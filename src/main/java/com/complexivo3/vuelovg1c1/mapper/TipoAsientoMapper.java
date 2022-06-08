package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.TipoAsientoDto;
import com.complexivo3.vuelovg1c1.model.TipoAsiento;

public class TipoAsientoMapper {

    public static TipoAsientoDto toDto(TipoAsiento tipo) {
        TipoAsientoDto dto = new TipoAsientoDto();
        dto.setId(tipo.getId());
        dto.setNombre(tipo.getNombre());
        return dto;
    }

    public static TipoAsiento toAsiento(TipoAsientoDto dto) {
        TipoAsiento tipo = new TipoAsiento();
        tipo.setId(dto.getId());
        tipo.setNombre(dto.getNombre());
        return tipo;
    }
}
