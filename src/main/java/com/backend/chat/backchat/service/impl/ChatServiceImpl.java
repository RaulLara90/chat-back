package com.backend.chat.backchat.service.impl;

import com.backend.chat.backchat.models.documents.Mensaje;
import com.backend.chat.backchat.repository.ChatRepository;
import com.backend.chat.backchat.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements IChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Mensaje> obtenerUltimos10Mensajes() {
        return chatRepository.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardarMensaje(Mensaje mensaje) {
        return chatRepository.save(mensaje);
    }
}
