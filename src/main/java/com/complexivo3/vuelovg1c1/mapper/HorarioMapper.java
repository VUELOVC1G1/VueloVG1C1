package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.HorarioRequest;
import com.complexivo3.vuelovg1c1.dto.HorarioResponse;
import com.complexivo3.vuelovg1c1.model.Horario;

public class HorarioMapper {

    public static Horario toHorario(HorarioRequest horarioRequest){
        Horario ho= new Horario();
        ho.setId(horarioRequest.getId());
        ho.setFechaFin(horarioRequest.getFechaFin());
        ho.setFechaInicio(horarioRequest.getFechaInicio());
        return  ho;
    }

    public static HorarioResponse toHorarioResponse(Horario horario){
        HorarioResponse horarioResponse=new HorarioResponse();
        horarioResponse.setId(horario.getId());
        horarioResponse.setFechaFin(horario.getFechaFin());
        horarioResponse.setFechaInicio(horario.getFechaInicio());
        return horarioResponse;
    }
}
