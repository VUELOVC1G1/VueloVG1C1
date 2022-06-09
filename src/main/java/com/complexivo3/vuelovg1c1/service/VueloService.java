package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.VueloMapper;
import com.complexivo3.vuelovg1c1.model.Vuelo;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VueloService implements IVueloService{

    private final IVueloRepository iVueloRepository;
    @Transactional(readOnly = true)
    @Override
    public VueloResponse findByVueloId(Long id) {
        Vuelo vuelo= iVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vuelo  con id: " + id));
        return VueloMapper.toVueloResponse(vuelo);
    }

    @Transactional
    @Override
    public void  guardarVuelo(VueloRequest vueloRequest) {
        Vuelo vuelo=VueloMapper.toVuelo(vueloRequest);
        Vuelo v= iVueloRepository.save(vuelo);
    }
    @Transactional
    @Override
    public VueloResponse deltevyIdVuelo(Long id) {

        Vuelo r= iVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vuelo con  con id: " + id));
        iVueloRepository.delete(r);
        return VueloMapper.toVueloResponse(r);
    }
    @Transactional
    @Override
    public Boolean updateVuelo(VueloRequest vueloRequest) {
        return null;
    }
}
