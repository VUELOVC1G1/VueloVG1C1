package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.VueloHoy;
import com.complexivo3.vuelovg1c1.dto.VueloRequest;
import com.complexivo3.vuelovg1c1.dto.VueloResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.*;
import com.complexivo3.vuelovg1c1.model.*;
import com.complexivo3.vuelovg1c1.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VueloService implements IVueloService {

    private final IVueloRepository iVueloRepository;
    private final IRutaRepository rutaRepository;
    private final IPromocionRepository promocionRepository;
    private final IAvionRepository iAvionRepository;
    private final IAsientoRepository asientoRepository;
    private final IBoletoRepository boletoRepository;

    private final IPasajeroRepository pasajeroRepository;


    @Transactional(readOnly = true)
    @Override
    public VueloResponse findByVueloId(Long id) {
        Vuelo vuelo = iVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vuelo  con id: " + id));
        return VueloMapper.toVueloResponse(vuelo);
    }

    @Transactional
    @Override
    public void guardarVuelo(VueloRequest vueloRequest) {
        Vuelo vuelo = VueloMapper.toVuelo(vueloRequest);
        Avion avion = iAvionRepository.findById(vueloRequest.getAvionid())
                .orElseThrow(() -> new NotFoundException("No existe un avion con id: " + vueloRequest.getAvionid()));
        vuelo.setAvion(avion);
        Vuelo v = iVueloRepository.save(vuelo);

    }

    @Transactional
    @Override
    public VueloResponse deltevyIdVuelo(Long id) {

        Vuelo r = iVueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un vuelo con  con id: " + id));
        iVueloRepository.delete(r);
        return VueloMapper.toVueloResponse(r);
    }

    @Transactional
    @Override
    public Boolean updateVuelo(VueloRequest vueloRequest) {
        Optional<Vuelo> vuel = iVueloRepository.findById(vueloRequest.getId());
        if (vuel.isPresent()) {
            vuel.get().setEstado(vueloRequest.isEstado());
            vuel.get().setFechaCreacion(new Date(vueloRequest.getFechaCreacion().getTime() + (1000 * 60 * 60 * 24)));
            vuel.get().setFechaVuelo(new Date(vueloRequest.getFechaVuelo().getTime() + (1000 * 60 * 60 * 24)));
            vuel.get().setObservacion(vueloRequest.getObservacion());
            vuel.get().setPrecio(vueloRequest.getPrecio());
            vuel.get().setSalaEspera(vueloRequest.getSalaEspera());
            vuel.get().setHorario(HorarioMapper.toHorario(vueloRequest.getHorarioRequest()));
            vuel.get().setRuta(RutaMapper.toRuta(vueloRequest.getRutaRequest()));
            vuel.get().setTipo(TipoVueloMapper.toTipoVuelo(vueloRequest.getTipoVueloRequest()));

            if (Objects.nonNull(vueloRequest.getUCharterResponse()))
                vuel.get().setUsuarioCharter(UCharterMapper.toUCharter2(vueloRequest.getUCharterResponse()));

            Avion avion = iAvionRepository.findById(vueloRequest.getAvionid())
                    .orElseThrow(() -> new NotFoundException("No existe un avion con id: " + vueloRequest.getAvionid()));
            vuel.get().setAvion(avion);

            try {
                iVueloRepository.save(vuel.get());
                return true;
            } catch (Exception ex) {
                throw new NotFoundException("No existe un vuelo id: " + vueloRequest.getId());
            }
        } else {
            throw new NotFoundException("No existe un vuelo con id: " + vueloRequest.getId());
        }

    }


    @Override
    public List<VueloResponse> getVuelosDisponiblesPorRuta(Long idRuta) {
        if (rutaRepository.existsById(idRuta)) {
            List<Vuelo> vuelos = iVueloRepository.getVuelosDisponiblesPorRuta(idRuta, true);
            return toVuelosResponse(vuelos);
        }
        return null;
    }


    @Override
    public VueloResponse getVueloDisponiblePorId(Long idVuelo) {
        Vuelo vuelo = iVueloRepository.getVueloDisponiblePorId(idVuelo, true).orElseThrow(() -> new NotFoundException("No existe un vuelo con  con id: " + idVuelo));
        return VueloMapper.toVueloResponse(vuelo);
    }


    @Override
    public List<VueloResponse> getVuelosDisponiblesPorFechaRuta(Long idRuta, String fecha) {
        Date fechaVuelo = getDate(fecha);
        if (rutaRepository.existsById(idRuta) && fechaVuelo != null) {
            List<Vuelo> vuelos = iVueloRepository.getVuelosDisponiblesPorFechaRuta(idRuta, fechaVuelo, true);
            return toVuelosResponse(vuelos);
        }
        return null;
    }


    @Override
    public List<VueloResponse> getVuelosDisponiblesPorFecha(String fecha) {
        Date fechaVuelo = getDate(fecha);
        if (fechaVuelo != null) {
            List<Vuelo> vuelos = iVueloRepository.getVuelosDisponiblesPorFecha(fechaVuelo, true);
            return toVuelosResponse(vuelos);
        }
        return null;
    }


    @Override
    public List<VueloResponse> getVuelosDisponibles() {
        List<Vuelo> vuelos = iVueloRepository.getVuelosPorEstado(true);
        return toVuelosResponse(vuelos);
    }


    private List<VueloResponse> toVuelosResponse(List<Vuelo> vuelos) {
        List<VueloResponse> response = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            response.add(VueloMapper.toVueloResponse(vuelo));
        }
        return response;
    }


    private Date getDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formato.parse(fecha);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public List<VueloResponse> getVuelosDisponiblesPromocion(Long idPromocion) {
        if (promocionRepository.existsById(idPromocion)) {
            List<Vuelo> vuelos = iVueloRepository.getVuelosDisponiblesPromocion(idPromocion, true);
            return toVuelosResponse(vuelos);
        }
        return null;
    }

    @Override
    public List<VueloResponse> getVuelosDisponiblesPromocionRuta(Long idPromocion, Long idRuta) {
        if (promocionRepository.existsById(idPromocion) && rutaRepository.existsById(idRuta)) {
            List<Vuelo> vuelos = iVueloRepository.getVuelosDisponiblesPromocionRuta(idPromocion, idRuta, true);
            return toVuelosResponse(vuelos);
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<VueloResponse> findAll() {
        return iVueloRepository.findAll()
                .stream().map(VueloMapper::toVueloResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public boolean asientoDisponible(Long vueloId, Long asientoId) {
        Vuelo vuelo = iVueloRepository.findById(vueloId)
                .orElseThrow(() -> new NotFoundException("No existe un vuelo con id: " + vueloId));

        if (!vuelo.isEstado()) return true;

        Asiento asiento = asientoRepository.findById(asientoId)
                .orElseThrow(() -> new NotFoundException("No existe un asiento con id: " + asientoId));

        Optional<Boleto> boletoReservado = vuelo.getBoletos()
                .stream().filter(a -> a.getAsientos().contains(asiento))
                .findFirst();

        return !boletoReservado.isPresent();
    }

    public List<VueloHoy> vuelosHoyPasajero(Long id) {
        Pasajero pasajero = pasajeroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el pasajero con id: " + id));

        List<Boleto> boletos = boletoRepository.findAllByPasajeroAndFechaLessThanEqual(pasajero, new Date());

        return boletos
                .stream().map(b -> {
                    VueloHoy hoy = new VueloHoy();
                    hoy.setVueloId(b.getVuelo().getId());
                    hoy.setDestino(b.getVuelo().getRuta().getDestino());
                    hoy.setFecha(b.getVuelo().getFechaVuelo());
                    return hoy;
                }).collect(Collectors.toList());
    }
}
