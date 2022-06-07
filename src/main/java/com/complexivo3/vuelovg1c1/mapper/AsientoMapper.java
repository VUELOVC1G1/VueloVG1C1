package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.AsientoDto;
import com.complexivo3.vuelovg1c1.model.Asiento;

public class AsientoMapper {

    public static AsientoDto toDto(Asiento asiento) {
        AsientoDto dto = new AsientoDto();
        dto.setId(asiento.getId());
        dto.setPrecio(asiento.getPrecio());
        dto.setNombre(asiento.getNombre());
        dto.setTipoAsiento(TipoAsientoMapper.toDto(asiento.getTipoAsiento()));
        return new AsientoDto();
    }

    public static Asiento toAsiento(AsientoDto dto) {
        Asiento asiento = new Asiento();
        asiento.setId(dto.getId());
        asiento.setNombre(dto.getNombre());
        asiento.setPrecio(dto.getPrecio());
        asiento.setTipoAsiento(TipoAsientoMapper.toAsiento(dto.getTipoAsiento()));
        return asiento;
    }
}
