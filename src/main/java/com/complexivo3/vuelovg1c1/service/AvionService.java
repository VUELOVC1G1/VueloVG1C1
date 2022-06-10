package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.AvionDto;
import com.complexivo3.vuelovg1c1.dto.AvionRequest;
import com.complexivo3.vuelovg1c1.dto.AvionResponse;
import com.complexivo3.vuelovg1c1.mapper.AsientoMapper;
import com.complexivo3.vuelovg1c1.mapper.AvionMapper;
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
public class AvionService implements IAvionService{

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
    public void update(AvionDto request) {
        Avion avion = AvionMapper.toAvion(request);

        List<Asiento> asientos = request.getAsientos()
                .stream().map(AsientoMapper::toAsiento)
                .collect(Collectors.toList());
        avion.getAsientos().addAll(asientos);
        asientos.forEach(a -> a.setAvion(avion));

        avionRepository.save(avion);
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

    public void deleteById(Long id) {
        // TODO: handle exceptions
        if (avionRepository.existsById(id))
            avionRepository.deleteById(id);
    }


    /** ---------------------------------------- MÉTODOS PROPUESTOS PARA ESTE SERVICIO ---------------------------------------- 
     * @author Eduardo Mendieta
    */
    @Override
    public AvionResponse crearAvion(AvionRequest request) {
        Avion avion = AvionMapper.toAvion(request);
        return AvionMapper.toResponse(avionRepository.save(avion));
    }
}
