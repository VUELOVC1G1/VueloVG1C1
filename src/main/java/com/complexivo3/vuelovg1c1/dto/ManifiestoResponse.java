package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

@Data
public class ManifiestoResponse {
    private Long id;
    private String documento;
    private UCharterResponse charterResponse;
}
