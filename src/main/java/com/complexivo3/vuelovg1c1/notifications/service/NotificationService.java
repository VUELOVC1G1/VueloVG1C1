package com.complexivo3.vuelovg1c1.notifications.service;

import com.complexivo3.vuelovg1c1.model.Vuelo;
import com.complexivo3.vuelovg1c1.notifications.dto.PushNotificationRequest;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final IVueloRepository vueloRepository;
    private final PushNotificationService notificationService;

    @Transactional(readOnly = true)
    @Scheduled(cron = "0 */1 * * * *")
    public void scheduleTaskUsingCronExpression() {

        List<Vuelo> reservas = vueloRepository.getVuelos();

        for (Vuelo reserva : reservas) {
            System.out.println("RESERVAS: " + reservas.size());

            reserva.getBoletos()
                    .forEach(b -> {
                        if (!b.getPasajero().getUsuario().getAndroidToken().isEmpty()) {
                            PushNotificationRequest request = new PushNotificationRequest();
                            request.setTitle("¡Tu vuelo a " + reserva.getRuta().getDestino() + ", sale en dos horas!");
                            request.setMessage("Recuerda llegar a tiempo, no olvides tus documentos");
                            request.setToken(b.getPasajero().getUsuario().getAndroidToken());
                            notificationService.sendPushNotificationToToken(request);
                        }
                    });
        }
    }

}
