package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.UCharterResponse;

public interface ICharterService {
    UCharterResponse findByUsuarioId(Long id);
}
