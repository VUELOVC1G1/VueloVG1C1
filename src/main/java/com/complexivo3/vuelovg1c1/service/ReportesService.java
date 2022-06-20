package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.VuelosDiarios;
import com.complexivo3.vuelovg1c1.model.IVuelosGroupByDay;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ReportesService {

    private final IVueloRepository vueloRepository;

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
    public Map<Date, Integer> getVuelosDiariosB() {
        Map<Date, Integer> vuelos = new HashMap<>();
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

}
