package com.backend.chat.backchat.models.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@Document(collection = "mensajes")
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String texto;
    private String tipo;
    private String username;
    private Long fecha;
    private String color;
}
