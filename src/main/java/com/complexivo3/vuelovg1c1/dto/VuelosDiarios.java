package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VuelosDiarios {
    private List<String> meses = new ArrayList<>();
    private List<Integer> vuelos = new ArrayList<>();
}
