package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.PromocionMapper;
import com.complexivo3.vuelovg1c1.model.Promocion;
import com.complexivo3.vuelovg1c1.model.Vuelo;
import com.complexivo3.vuelovg1c1.repository.IPromocionRepository;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PromocionService implements IPromocionService{

    private final IPromocionRepository iPromocionRepository;
    private final IVueloRepository iVueloRepository;

    @Transactional(readOnly = true)
    @Override
    public PromocionResponse findByPromocionId(Long id) {
        Promocion promocion= iPromocionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe una promocion con id: " + id));
        return PromocionMapper.topromocionresponse(promocion);
    }

    @Transactional
    @Override
    public void guardarPromocion(PromocionRequest promocionRequest) {
        Promocion p=PromocionMapper.topromocion(promocionRequest);
        Vuelo vuelo= iVueloRepository.findById(promocionRequest.getVueloid())
                .orElseThrow(() -> new NotFoundException("No existe un veuelo con id: " + promocionRequest));
        p.setVuelo(vuelo);
        Promocion v= iPromocionRepository.save(p);
    }

    @Override
    public PromocionResponse deltevyIdPromocion(Long id) {
        Promocion p= iPromocionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe una promocion con  con id: " + id));
        iPromocionRepository.delete(p);
        return PromocionMapper.topromocionresponse(p);
    }

    @Override
    public Boolean updatePromocion(PromocionRequest promocionRequest) {


        return null;
    }
}
