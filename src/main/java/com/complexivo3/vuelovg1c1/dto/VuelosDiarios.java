package com.complexivo3.vuelovg1c1.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class VuelosDiarios {
    private List<Date> meses = new ArrayList<>();
    private List<Integer> vuelos = new ArrayList<>();
}
