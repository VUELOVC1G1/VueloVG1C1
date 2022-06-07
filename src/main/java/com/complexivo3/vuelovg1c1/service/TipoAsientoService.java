package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.TipoAsientoDto;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.TipoAsientoMapper;
import com.complexivo3.vuelovg1c1.model.TipoAsiento;
import com.complexivo3.vuelovg1c1.repository.ITipoAsientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TipoAsientoService {

    private final ITipoAsientoRepository tipoAsientoRepository;

    @Transactional(readOnly = true)
    public List<TipoAsientoDto> findAll() {
        return tipoAsientoRepository.findAll()
                .stream().map(TipoAsientoMapper::toDto)
                .collect(Collectors.toList());
    }

    private TipoAsiento findByIdEntity(Long id) {
        return tipoAsientoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un Tipo de Asiento con id: " + id));
    }

    @Transactional(readOnly = true)
    public TipoAsientoDto findById(Long id) {
        return TipoAsientoMapper.toDto(findByIdEntity(id));
    }
}
