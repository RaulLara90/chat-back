package com.backend.chat.backchat.service;

import com.backend.chat.backchat.models.documents.Mensaje;

import java.util.List;

public interface IChatService {

    List<Mensaje> obtenerUltimos10Mensajes();

    Mensaje guardarMensaje(Mensaje mensaje);
}
