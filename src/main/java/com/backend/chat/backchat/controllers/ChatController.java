package com.backend.chat.backchat.controllers;

import com.backend.chat.backchat.models.documents.Mensaje;
import com.backend.chat.backchat.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {

    @Autowired
    private IChatService chatService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private String[] colores = {"red", "green", "blue", "magenta", "purple", "orange"};

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje(Mensaje mensaje) {
        mensaje.setFecha(new Date().getTime());
        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
            mensaje.setColor(colores[new Random().nextInt(colores.length)]);
            mensaje.setTexto("nuevo usuario");
        } else {
            chatService.guardarMensaje(mensaje);
        }
        return mensaje;
    }


    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String estaEscribiendo(String username) {
        return username.concat(" está escribiendo ...");
    }

    @MessageMapping("/historial")
    public void historial(String clienteId) {
        simpMessagingTemplate.convertAndSend("/chat/historial/" + clienteId, chatService.obtenerUltimos10Mensajes());
    }
}
