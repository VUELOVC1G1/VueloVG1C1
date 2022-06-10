package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.MaletaDto;
import com.complexivo3.vuelovg1c1.dto.MaletaRequest;
import com.complexivo3.vuelovg1c1.model.Maleta;

public class MaletaMapper {
    public static Maleta toMaleta(MaletaRequest request) {
        Maleta m = new Maleta();
        m.setPeso(request.getPeso());
        m.setPrecio(request.getPrecio());
        return m;
    }

    public static MaletaDto toDto(Maleta entity) {
        MaletaDto dto = new MaletaDto();
        dto.setId(entity.getId());
        dto.setPrecio(entity.getPrecio());
        dto.setPeso(entity.getPeso());
        return dto;
    }

}
