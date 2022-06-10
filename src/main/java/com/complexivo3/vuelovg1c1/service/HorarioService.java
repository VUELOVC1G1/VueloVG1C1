package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.HorarioRequest;
import com.complexivo3.vuelovg1c1.dto.HorarioResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.HorarioMapper;
import com.complexivo3.vuelovg1c1.mapper.RutaMapper;
import com.complexivo3.vuelovg1c1.model.Horario;
import com.complexivo3.vuelovg1c1.model.Ruta;
import com.complexivo3.vuelovg1c1.repository.IHorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HorarioService implements IHorarioService{

    private final IHorarioRepository iHorarioRepository;

    @Transactional(readOnly = true)
    @Override
    public HorarioResponse findByHorarioId(Long id) {
        Horario horario=iHorarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un horario  con id: " + id));
        return HorarioMapper.toHorarioResponse(horario);
    }

    @Transactional
    @Override
    public HorarioResponse guardarhorario(HorarioRequest horarioRequest) {
        Horario horario= HorarioMapper.toHorario(horarioRequest);
        return HorarioMapper.toHorarioResponse(iHorarioRepository.save(horario));
    }

    @Transactional
    @Override
    public HorarioResponse deltevyIdhorario(Long id) {
        Horario h= iHorarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un horario  con id: " + id));
        iHorarioRepository.delete(h);
        return HorarioMapper.toHorarioResponse(h);
    }

    @Transactional
    @Override
    public Boolean updateIdhorario(HorarioRequest horarioRequest) {
        Optional<Horario> ur=iHorarioRepository.findById(horarioRequest.getId());
        if (ur.isPresent()) {
            ur.get().setFechaInicio(new Date(horarioRequest.getFechaInicio().getTime()+(1000 * 60 * 60 * 24)));
            ur.get().setFechaFin(new Date(horarioRequest.getFechaFin().getTime()+(1000 * 60 * 60 * 24)));

            try {
                Horario horario = iHorarioRepository.save(ur.get());
                return true;
            } catch (Exception ex) {
                throw new  NotFoundException("No existe un horario con id: " + horarioRequest.getId());
            }
        }else{
            throw new  NotFoundException("No existe un horario con id: " + horarioRequest.getId());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<HorarioResponse> findAll() {
        return iHorarioRepository.findAll()
                .stream().map(HorarioMapper::toHorarioResponse)
                .collect(Collectors.toList());
    }


}
