package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.*;
import com.complexivo3.vuelovg1c1.model.Usuario;
import org.springframework.stereotype.Service;

public interface IAuthService {
    UserResponse doLogin(LoginRequest request);

    PasajeroResponse signupPasajero(PasajeroRequest request);

    EmpleadoResponse signupEmpleado(EmpleadoRequest request);

    UCharterResponse signupCharter(CharterRequest request);

}
