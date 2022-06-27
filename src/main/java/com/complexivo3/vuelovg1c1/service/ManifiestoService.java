package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.ManifiestoRequest;
import com.complexivo3.vuelovg1c1.dto.ManifiestoResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.ManifiestoMapper;
import com.complexivo3.vuelovg1c1.model.Manifiesto;
import com.complexivo3.vuelovg1c1.model.UsuarioCharter;
import com.complexivo3.vuelovg1c1.repository.IManifiestoRepository;
import com.complexivo3.vuelovg1c1.repository.IUCharterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ManifiestoService implements IManifiestoService{
    
    private final IManifiestoRepository manifiestoRepository;
    private final IUCharterRepository charterRepository;

    @Override
    public List<ManifiestoResponse> getAllManifiestos() {
        List<Manifiesto> manifiestos = manifiestoRepository.findAll();
        List<ManifiestoResponse> response = new ArrayList<>();
        for (Manifiesto manifiesto : manifiestos) {
            response.add(ManifiestoMapper.toResponse(manifiesto));
        }
        return response;
    }

    @Override
    public  List<ManifiestoResponse> getManifiestosPorCharter(Long idCharter) {
        List<Manifiesto> manifiestos =  manifiestoRepository.getManifiestosPorCharter(idCharter);
        List<ManifiestoResponse> response = new ArrayList<>();
        for (Manifiesto manifiesto : manifiestos) {
            response.add(ManifiestoMapper.toResponse(manifiesto));
        }
        return response;
    }

    @Override
    public ManifiestoResponse getManifiestoPorId(Long idManifiesto) {
        Manifiesto manifiesto = manifiestoRepository.findById(idManifiesto)
            .orElseThrow(() -> new NotFoundException("No existe un manifiesto con id: " + idManifiesto));
        return ManifiestoMapper.toResponse(manifiesto);
    }

    @Override
    public ManifiestoResponse crearManifiesto(ManifiestoRequest manifiestoRequest, Long idCharter) {
        UsuarioCharter charter = charterRepository.findById(idCharter)
            .orElseThrow(() -> new NotFoundException("No existe un usuario charter con id: " + idCharter));
        Manifiesto manifiesto = ManifiestoMapper.toManifiesto(manifiestoRequest);
        manifiesto.setUsuarioCharter(charter);
        return ManifiestoMapper.toResponse(manifiestoRepository.save(manifiesto));
    }

    @Override
    public ManifiestoResponse modificarManifiesto(ManifiestoRequest manifiestoRequest, Long idManifiesto,
            Long idCharter) {
        UsuarioCharter charter = charterRepository.findById(idCharter)
            .orElseThrow(() -> new NotFoundException("No existe un usuario charter con id: " + idCharter));
        Manifiesto manifiesto = manifiestoRepository.findById(idManifiesto)
            .orElseThrow(() -> new NotFoundException("No existe un manifiesto con id: " + idManifiesto));
        manifiesto = ManifiestoMapper.toManifiesto(manifiestoRequest);
        manifiesto.setId(idManifiesto);
        manifiesto.setUsuarioCharter(charter);
        return ManifiestoMapper.toResponse(manifiestoRepository.save(manifiesto));
    }

    @Override
    public ManifiestoResponse eliminarManifiesto(Long idManifiesto) {
        Manifiesto manifiesto = manifiestoRepository.findById(idManifiesto)
            .orElseThrow(() -> new NotFoundException("No existe un manifiesto con id: " + idManifiesto));
        manifiestoRepository.deleteById(idManifiesto);
        return ManifiestoMapper.toResponse(manifiesto);
    }
}
