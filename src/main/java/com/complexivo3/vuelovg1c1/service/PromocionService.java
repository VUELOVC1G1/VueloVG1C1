package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PromocionRequest;
import com.complexivo3.vuelovg1c1.dto.PromocionResponse;
import com.complexivo3.vuelovg1c1.dto.PromocionVueloComercialResponse;
import com.complexivo3.vuelovg1c1.dto.PromocionVueloResponse;
import com.complexivo3.vuelovg1c1.exception.BadRequestException;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.PromocionMapper;
import com.complexivo3.vuelovg1c1.model.Promocion;
import com.complexivo3.vuelovg1c1.model.Vuelo;
import com.complexivo3.vuelovg1c1.repository.IPromocionRepository;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PromocionService implements IPromocionService {

    private final IPromocionRepository iPromocionRepository;
    private final IVueloRepository iVueloRepository;

    @Transactional(readOnly = true)
    @Override
    public PromocionVueloResponse findByPromocionId(Long id) {
        Promocion promocion = iPromocionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe una promocion con id: " + id));
        return PromocionMapper.topromocionresponse(promocion);
    }

    @Transactional
    @Override
    public void guardarPromocion(PromocionRequest promocionRequest) {
        Promocion p = PromocionMapper.topromocion(promocionRequest);
        Vuelo vuelo = iVueloRepository.findById(promocionRequest.getVueloid())
                .orElseThrow(() -> new NotFoundException("No existe un veuelo con id: " + promocionRequest.getVueloid()));
        if (vuelo.getPromociones().size() >= 1)
            throw new BadRequestException("Este vuelo ya tiene una promoción asignada");

        p.setVuelo(vuelo);
        Promocion v = iPromocionRepository.save(p);
    }

    @Transactional
    @Override
    public PromocionResponse deltevyIdPromocion(Long id) {
        Promocion p = iPromocionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe una promocion con  con id: " + id));
        iPromocionRepository.delete(p);
        return PromocionMapper.topromocionresponsedelete(p);
    }

    @Transactional
    @Override
    public Boolean updatePromocion(PromocionRequest promocionRequest) {
        Optional<Promocion> ur = iPromocionRepository.findById(promocionRequest.getId());
        if (ur.isPresent()) {
            Vuelo vuelo = iVueloRepository.findById(promocionRequest.getVueloid())
                    .orElseThrow(() -> new NotFoundException("No existe un vuelo con id: " + promocionRequest.getVueloid()));

            ur.get().setVuelo(vuelo);
            ur.get().setDescripcion(promocionRequest.getDescripcion());
            ur.get().setDescuento(promocionRequest.getDescuento());

            try {
                Promocion promocion = iPromocionRepository.save(ur.get());
                return true;
            } catch (Exception ex) {
                throw new NotFoundException("No existe una promocion con id: " + promocionRequest.getId());
            }
        } else {
            throw new NotFoundException("No existe una promocion con id: " + promocionRequest.getId());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<PromocionVueloResponse> findAll() {
        return iPromocionRepository.findAll()
                .stream().map(PromocionMapper::topromocionresponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<PromocionVueloComercialResponse> findAllComerciales() {
        List<Promocion> promocions = iPromocionRepository.findAll();
        List<Promocion> comerciales = promocions
                .stream().filter(p -> Objects.isNull(p.getVuelo().getUsuarioCharter()))
                .collect(Collectors.toList());
        return comerciales
                .stream().map(PromocionMapper::topromocionresponsecomercial)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<PromocionVueloResponse> findAllCharter() {
        List<Promocion> promocions = iPromocionRepository.findAll();
        List<Promocion> comerciales = promocions
                .stream().filter(p -> Objects.nonNull(p.getVuelo().getUsuarioCharter()))
                .collect(Collectors.toList());
        return comerciales
                .stream().map(PromocionMapper::topromocionresponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromocionResponse> findVueloPromociones(Long id) {
        Vuelo vuelo = iVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vuelo con id: " + id));
        List<Promocion> promocions = iPromocionRepository.findAllByVuelo(vuelo);

        return promocions.stream()
                .map(PromocionMapper::topromocionresponsedelete)
                .collect(Collectors.toList());
    }
}

