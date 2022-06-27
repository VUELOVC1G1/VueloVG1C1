package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.LoginRequest;
import com.complexivo3.vuelovg1c1.dto.UserDto;
import com.complexivo3.vuelovg1c1.dto.UsuarioRequest;
import com.complexivo3.vuelovg1c1.model.Usuario;

public class UsuarioMapper {

    public static Usuario loginRToUsuario(LoginRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(request.getPassword());
        return usuario;
    }

    public static Usuario requestToUser(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(request.getPassword());
        return usuario;
    }

    public static UserDto userToResponse(Usuario usuario) {
        UserDto response = new UserDto();
        response.setId(usuario.getId());
        response.setEmail(usuario.getCorreo());
        response.setRol(usuario.getRol());
        response.setPassword(usuario.getPassword());
        return response;
    }

}
