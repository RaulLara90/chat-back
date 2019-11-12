package com.backend.chat.backchat.repository;

import com.backend.chat.backchat.models.documents.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Mensaje, String> {

    List<Mensaje> findFirst10ByOrderByFechaDesc();
}
