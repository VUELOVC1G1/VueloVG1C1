package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.*;

public interface IAuthService {
    UserDto doLogin(LoginRequest request);

    PasajeroResponse signupPasajero(PasajeroRequest request);

    EmpleadoResponse signupEmpleado(EmpleadoRequest request);

    UCharterResponse signupCharter(CharterRequest request);

}
