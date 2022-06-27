# API Vuela V G1C1

Java Version: 1.8

### Swagger Docs
(local) http://localhost:8080/swagger-ui.html#/

(deployed) https://vuelav-api.herokuapp.com/swagger-ui.html#/

### Dependencies
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- postgresql
- lombok
- springfox-swagger2 v2.9.2
- springfox-swagger-ui v2.9.2
- firebase-admin v8.2.0
- spring-boot-starter-mail

## Firebase Service

Esta aplicación hace uso de Firebase Cloud Messaging para enviar notificaciones push alos dispositivos android, por lo que es necesario descargar un archivo de configuración que nos proporciona la [consola de Firebase](https://console.firebase.google.com/) al generar un proyecto.
Este archivo debe colocarse en resources/
