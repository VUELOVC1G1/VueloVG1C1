package com.complexivo3.vuelovg1c1.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioTokenRequest {
    private Long usuarioId;
    private String token;
}
