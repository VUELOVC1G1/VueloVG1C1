package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.TipoVueloRequest;
import com.complexivo3.vuelovg1c1.dto.TipoVueloResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.TipoVueloMapper;
import com.complexivo3.vuelovg1c1.model.TipoVuelo;
import com.complexivo3.vuelovg1c1.repository.ITipoVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TipoVueloService implements ITipoVueloService {

    private final ITipoVueloRepository iTipoVueloRepository;

    @Transactional(readOnly = true)
    @Override
    public TipoVueloResponse findBytipovueloId(Long id) {
        TipoVuelo r =iTipoVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un tipo de vuelo con id: " + id));
        return TipoVueloMapper.toResponsoTipoVuelo(r);
    }

    @Transactional
    @Override
    public TipoVueloResponse guardartipovuelo(TipoVueloRequest tipoVueloRequest) {
        TipoVuelo tp=TipoVueloMapper.toTipoVuelo(tipoVueloRequest);
        return TipoVueloMapper.toResponsoTipoVuelo(iTipoVueloRepository.save(tp));
    }

    @Transactional
    @Override
    public TipoVueloResponse deltevyIdtipovuelo(Long id) {
        TipoVuelo tp= iTipoVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un tipo de vuelo con id: " + id));
        iTipoVueloRepository.delete(tp);
        return TipoVueloMapper.toResponsoTipoVuelo(tp);

    }

    @Transactional
    @Override
    public Boolean updatetipovuelo(TipoVueloRequest tipoVueloRequest) {
        Optional<TipoVuelo> tp=iTipoVueloRepository.findById(tipoVueloRequest.getId());
        if (tp.isPresent()) {
            tp.get().setNombre(tipoVueloRequest.getNombre());

            try {
                TipoVuelo tipov = iTipoVueloRepository.save(tp.get());
                return true;
            } catch (Exception ex) {
                throw new  NotFoundException("No existe un tipo de vuelo  con id: " + tipoVueloRequest.getId());
            }
        }else{
            throw new  NotFoundException("No existe un tipo de vuelo   con id: " + tipoVueloRequest.getId());
        }
    }
}
