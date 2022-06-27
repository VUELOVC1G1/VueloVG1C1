package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.FacturaMes;
import com.complexivo3.vuelovg1c1.dto.VueloMensual;
import com.complexivo3.vuelovg1c1.dto.VuelosDiarios;
import com.complexivo3.vuelovg1c1.model.IVuelosGroupByDay;
import com.complexivo3.vuelovg1c1.repository.IBoletoRepository;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReportesService {

    private final IVueloRepository vueloRepository;
    private final IBoletoRepository boletoRepository;

    @Transactional(readOnly = true)
    public VuelosDiarios getVuelosDiariosA() {
        VuelosDiarios response = new VuelosDiarios();
        vueloRepository
                .findAllGroupByFechaVuelo()
                .stream().forEach(v -> {
                    response.getVuelos().add(v.getNumVuelos());
                    response.getMeses().add(v.getFecha());
                });
        return response;
    }

    @Transactional(readOnly = true)
    public Map<String, Integer> getVuelosDiariosB() {
        Map<String, Integer> vuelos = new HashMap<>();
        vueloRepository
                .findAllGroupByFechaVuelo()
                .stream().forEach(v -> {
                    vuelos.put(v.getFecha(), v.getNumVuelos());
                });
        return vuelos;
    }

    @Transactional(readOnly = true)
    public List<IVuelosGroupByDay> getVuelosDiariosC() {
        return vueloRepository.findAllGroupByFechaVuelo();
    }

    @Transactional(readOnly = true)
    public List<?> getFacturasMensuales() {
        return boletoRepository.findAllGroupByMonth()
                .stream().map(p -> {
                    FacturaMes f = new FacturaMes();
                    f.setFecha(p.getMes().concat("-01"));
                    f.setTotal(p.getTotal());
                    return f;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<VueloMensual> getVuelosMensuales() {
        return vueloRepository.findAllGroupByFechaVueloMensual()
                .stream().map(v -> {
                    VueloMensual m = new VueloMensual();
                    m.setNumVuelos(v.getNumVuelos());
                    m.setFecha(v.getFecha().concat("-01"));
                    return m;
                })
                .collect(Collectors.toList());
    }
}
