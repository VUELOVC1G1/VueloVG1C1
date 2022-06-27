package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.BoletoDto;
import com.complexivo3.vuelovg1c1.dto.BoletoRequest;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.*;
import com.complexivo3.vuelovg1c1.model.*;
import com.complexivo3.vuelovg1c1.notifications.dto.PushNotificationRequest;
import com.complexivo3.vuelovg1c1.notifications.service.PushNotificationService;
import com.complexivo3.vuelovg1c1.repository.IAsientoRepository;
import com.complexivo3.vuelovg1c1.repository.IBoletoRepository;
import com.complexivo3.vuelovg1c1.repository.IPasajeroRepository;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoletoService {

    private final IBoletoRepository boletoRepository;
    private final IAsientoRepository asientoRepository;
    private final IPasajeroRepository pasajeroRepository;
    private final IVueloRepository vueloRepository;

    private final EmailService emailService;
    private final PushNotificationService notificationService;

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

        Vuelo vuelo = vueloRepository.findById(request.getVueloId())
                .orElseThrow(() -> new NotFoundException("No existe un vuelo con id: " + request.getVueloId()));

        pago.setBoleto(boleto);
        maletas.forEach(m -> m.setBoleto(boleto));
        asientos.forEach(a -> a.getBoletos().add(boleto));
        vuelo.getBoletos().add(boleto);

        boleto.setVuelo(vuelo);
        boleto.setPagos(pago);
        boleto.setMaletas(maletas);
        boleto.setAsientos(asientos);
        boleto.setPasajero(pasajero);
        boletoRepository.save(boleto);

        String fechaReserva = request.getFecha().toInstant().atOffset(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String destino = vuelo.getRuta().getDestino();

        sendNotification(pasajero, fechaReserva, destino);
        sendEmail(pasajero.getUsuario().getCorreo(), fechaReserva, destino);
    }

    private void sendNotification(Pasajero pasajero, String date, String destino) {
        if (Objects.nonNull(pasajero.getUsuario().getAndroidToken())) {
            PushNotificationRequest request = new PushNotificationRequest();
            request.setTitle("¡Has reservado un vuelo!");
            request.setMessage("Tu vuelo a " + destino + ", esta reservado para el dia: " + date);
            request.setToken(pasajero.getUsuario().getAndroidToken());
            notificationService.sendPushNotificationToToken(request);
        }
    }

    private void sendEmail(String email, String date, String destino) {
        emailService.enviarEmail(email, "¡Has reservado un vuelo!", "Tu vuelo a " + destino + ", esta reservado para el dia: " + date);
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
        Boleto boleto = boletoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un boleto con id: " + id));
        List<Asiento> asientos = boleto.getAsientos();
        for (Asiento asiento : asientos) {
            asiento.getBoletos().remove(boleto);
        }

        boletoRepository.save(boleto);
        boletoRepository.deleteById(id);
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

        dto.setVuelo(VueloMapper.toVueloResponse(boleto.getVuelo()));

        return dto;
    }

    @Transactional(readOnly = true)
    public List<BoletoDto> findAll() {
        return boletoRepository.findAll()
                .stream().map(this::toBoletoDto)
                .collect(Collectors.toList());
    }
}
