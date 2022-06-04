package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class UserResponse {

    private long id;
    private String email;
    private String password;
    private String rol;
    // TODO: token
}
