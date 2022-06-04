package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.LoginRequest;
import com.complexivo3.vuelovg1c1.dto.UserResponse;
import com.complexivo3.vuelovg1c1.model.Usuario;

public interface IAuthService {
    UserResponse doLogin(LoginRequest request);
    UserResponse signup(Usuario usuario);

}
