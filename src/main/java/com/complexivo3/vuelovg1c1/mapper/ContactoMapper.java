package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.ContactoDto;
import com.complexivo3.vuelovg1c1.dto.ContactoRequest;
import com.complexivo3.vuelovg1c1.model.Contacto;

public class ContactoMapper {

    public static Contacto toContacto(ContactoRequest request) {
        Contacto c = new Contacto();
        c.setCedula(request.getCedula());
        c.setNombres(request.getNombres());
        c.setApellidos(request.getApellidos());
        c.setCorreo(request.getCorreo());
        c.setDescripcion(request.getDescripcion());
        return c;
    }

    public static ContactoDto toDto(Contacto contacto) {
        return new ContactoDto(
                contacto.getId(),
                contacto.getCedula(),
                contacto.getCorreo(),
                contacto.getNombres(),
                contacto.getApellidos(),
                contacto.getDescripcion(),
                contacto.getFecha());
    }

}
