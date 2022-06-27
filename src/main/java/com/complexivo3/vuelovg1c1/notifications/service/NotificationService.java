package com.complexivo3.vuelovg1c1.notifications.service;

import com.complexivo3.vuelovg1c1.model.Vuelo;
import com.complexivo3.vuelovg1c1.notifications.dto.PushNotificationRequest;
import com.complexivo3.vuelovg1c1.repository.IVueloRepository;
import com.complexivo3.vuelovg1c1.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final IVueloRepository vueloRepository;
    private final PushNotificationService notificationService;
    private final EmailService emailService;

    @Transactional(readOnly = true)
    @Scheduled(cron = "0 */1 * * * *")
    public void scheduleTaskUsingCronExpression() {

        List<Vuelo> reservas = vueloRepository.getVuelos();
        System.out.println("Checking vuelos...");

        for (Vuelo reserva : reservas) {
            System.out.println("RESERVAS: " + reservas.size());

            reserva.getBoletos()
                    .forEach(b -> {
                        if (Objects.nonNull(b.getPasajero().getUsuario().getAndroidToken())) {
                            String title = "¡Tu vuelo a " + reserva.getRuta().getDestino() + ", sale en dos horas!";
                            String message = "Recuerda llegar a tiempo, no olvides tus documentos";

                            PushNotificationRequest request = new PushNotificationRequest();
                            request.setTitle(title);
                            request.setMessage(message);
                            request.setToken(b.getPasajero().getUsuario().getAndroidToken());
                            notificationService.sendPushNotificationToToken(request);

                            emailService.enviarEmail(b.getPasajero().getUsuario().getCorreo(), title, message);

                        }
                    });
        }
    }

}
