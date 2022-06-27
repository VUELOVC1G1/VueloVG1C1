package com.complexivo3.vuelovg1c1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String correo;

    private final JavaMailSender javaMailSender;

    public void enviarEmail(String correoReceptor, String asunto, String cuerpoMensaje){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(correo);
        mail.setTo(correoReceptor);
        mail.setSubject(asunto);
        mail.setText(cuerpoMensaje);
        try {
            javaMailSender.send(mail);
        } catch (Exception e) {
            log.error("Error email: " + e.getMessage());
        }
    }

}
