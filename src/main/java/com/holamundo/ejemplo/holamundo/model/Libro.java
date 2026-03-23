package com.holamundo.ejemplo.holamundo.model;

import  lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Libro {
    private int id, fechaPublicacion;

    private String isbn, titulo, editorial, autor;
}
//http://localhost:8081/api/v1/libros postman url dont forget