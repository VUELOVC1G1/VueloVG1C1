package com.complexivo3.vuelovg1c1.notifications.controller;

import com.complexivo3.vuelovg1c1.notifications.dto.UsuarioTokenRequest;
import com.complexivo3.vuelovg1c1.notifications.service.UserTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/token")
public class TokenController {

    private final UserTokenService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UsuarioTokenRequest usuario) {
        userService.save(usuario);
        return ResponseEntity.ok().build();
    }

}
