package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.BoletoDto;
import com.complexivo3.vuelovg1c1.dto.BoletoRequest;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.*;
import com.complexivo3.vuelovg1c1.model.*;
import com.complexivo3.vuelovg1c1.repository.IAsientoRepository;
import com.complexivo3.vuelovg1c1.repository.IBoletoRepository;
import com.complexivo3.vuelovg1c1.repository.IPasajeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoletoService {

    private final IBoletoRepository boletoRepository;
    private final IAsientoRepository asientoRepository;
    private final IPasajeroRepository pasajeroRepository;

    @Transactional
    public void save(BoletoRequest request) {
        Boleto boleto = BoletoMapper.toBoleto(request);

        Pago pago = PagoMapper.toPago(request.getPago());

        List<Maleta> maletas = request.getMaletas()
                .stream().map(MaletaMapper::toMaleta)
                .collect(Collectors.toList());

        List<Asiento> asientos = request.getAsientos()
                .stream().map(a -> asientoRepository
                        .findById(a.getId())
                        .orElseThrow(() -> new NotFoundException("No existe un asiento con id: " + a.getId())))
                .collect(Collectors.toList());

        Pasajero pasajero = pasajeroRepository.findById(request.getPasajeroId())
                .orElseThrow(() -> new NotFoundException("No existe un pasajero con id: " + request.getPasajeroId()));

        boleto.setPagos(pago);
        boleto.setMaletas(maletas);
        boleto.setAsientos(asientos);
        boleto.setPasajero(pasajero);
        boletoRepository.save(boleto);
    }

    @Transactional(readOnly = true)
    public BoletoDto findById(long id) {
        Boleto boleto = boletoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un boleto con id: " + id));

        return toBoletoDto(boleto);
    }

    @Transactional(readOnly = true)
    public List<BoletoDto> findByPasajeroId(long id) {
        Pasajero pasajero = pasajeroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un pasajero con id: " + id));

        List<Boleto> boletos = boletoRepository.findAllByPasajero(pasajero);

        return boletos.stream().map(this::toBoletoDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(long id) {
        if (boletoRepository.existsById(id))
            boletoRepository.deleteById(id); //TODO: handle exceptions
    }

    private BoletoDto toBoletoDto(Boleto boleto) {
        BoletoDto dto = BoletoMapper.toDto(boleto);

        dto.setPago(PagoMapper.toDto(boleto.getPagos()));

        dto.setPasajero(PasajeroMapper.toResponse(boleto.getPasajero()));

        dto.setAsientos(boleto.getAsientos()
                .stream().map(AsientoMapper::toDto)
                .collect(Collectors.toList()));

        dto.setMaletas(boleto.getMaletas()
                .stream().map(MaletaMapper::toDto)
                .collect(Collectors.toList()));

        return dto;
    }

}
