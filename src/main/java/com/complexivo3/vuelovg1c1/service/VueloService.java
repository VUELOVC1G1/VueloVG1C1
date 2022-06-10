package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.*;
import com.complexivo3.vuelovg1c1.model.Vuelo;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

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
        Optional<Vuelo> vuel=iVueloRepository.findById(vueloRequest.getId());
        if (vuel.isPresent()) {
            vuel.get().setEstado(vueloRequest.isEstado());
            vuel.get().setFechaCreacion(new Date(vueloRequest.getFechaCreacion().getTime()+(1000 * 60 * 60 * 24)));
            vuel.get().setFechaVuelo(new Date(vueloRequest.getFechaVuelo().getTime()+(1000 * 60 * 60 * 24)));
            vuel.get().setObservacion(vueloRequest.getObservacion());
            vuel.get().setPrecio(vueloRequest.getPrecio());
            vuel.get().setHorario(HorarioMapper.toHorario(vueloRequest.getHorarioRequest()));
            vuel.get().setRuta(RutaMapper.toRuta(vueloRequest.getRutaRequest()));
            vuel.get().setTipo(TipoVueloMapper.toTipoVuelo(vueloRequest.getTipoVueloRequest()));
            vuel.get().setUsuarioCharter(UCharterMapper.toUCharter2(vueloRequest.getUCharterResponse()));

            try {
                Vuelo vuelo = iVueloRepository.save(vuel.get());
                return true;
            } catch (Exception ex) {
                throw new  NotFoundException("No existe un vuelo id: " + vueloRequest.getId());
            }
        }else{
            throw new  NotFoundException("No existe un vuelo con id: " + vueloRequest.getId());
        }

    }
}
