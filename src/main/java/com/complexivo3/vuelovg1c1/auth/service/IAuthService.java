package com.complexivo3.vuelovg1c1.auth.service;

import com.complexivo3.vuelovg1c1.auth.dto.LoginRequest;
import com.complexivo3.vuelovg1c1.auth.dto.UserResponse;
import com.complexivo3.vuelovg1c1.auth.model.Usuario;

public interface IAuthService {
    UserResponse doLogin(LoginRequest request);
    UserResponse signup(Usuario usuario);

}
