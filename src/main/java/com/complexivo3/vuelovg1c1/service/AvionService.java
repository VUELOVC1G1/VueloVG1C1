package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.AsientoDto;
import com.complexivo3.vuelovg1c1.dto.AvionDto;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.AsientoMapper;
import com.complexivo3.vuelovg1c1.mapper.AvionMapper;
import com.complexivo3.vuelovg1c1.mapper.TipoAsientoMapper;
import com.complexivo3.vuelovg1c1.model.Asiento;
import com.complexivo3.vuelovg1c1.model.Avion;
import com.complexivo3.vuelovg1c1.repository.IAsientoRepository;
import com.complexivo3.vuelovg1c1.repository.IAvionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AvionService {

    private final IAvionRepository avionRepository;
    private final IAsientoRepository asientoRepository;


    @Transactional(readOnly = true)
    public List<AvionDto> findAll() {
        return avionRepository.findAll()
                .stream().map(AvionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(AvionDto request) {
        Avion avion = AvionMapper.toAvion(request);

        List<Asiento> asientos = request.getAsientos()
                .stream().map(AsientoMapper::toAsiento)
                .collect(Collectors.toList());

        Avion saved = avionRepository.save(avion);
        asientos.forEach(a -> a.setAvion(saved));
        avion.setAsientos(asientoRepository.saveAll(asientos));
    }

    @Transactional
    public AvionDto update(AvionDto request) {
        Avion avion = avionRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException("No existe un avión con id: " + request.getId()));
        Avion saved = avionRepository.save(avion);
        return AvionMapper.toDto(saved);
    }

    private List<Asiento> generateAsientos(int numColumns, int numAsientos) {
        char[] columns = new char[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columns[i] = (char) (65 + i);
        }

        int rows = numAsientos / numColumns;
        List<Asiento> asientos = new ArrayList<>();

        for (int i = 0; i < numColumns; i++) {
            for (int j = 1; j <= rows; j++) {
                asientos.add(new Asiento(j + String.valueOf(columns[i])));
            }
        }
        return asientos;
    }

}
