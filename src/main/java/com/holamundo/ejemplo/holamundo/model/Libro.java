package com.holamundo.ejemplo.holamundo.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @NotNull(message = "EL ID ES OBLIGATORIO")
    @Min(value = 1, message = "EL ID DEBE SER UN NÚMERO POSITIVO")
    // Nota: Eliminé el Max(10) para que puedas tener más de 10 libros
    private Integer id;

    @NotBlank(message = "EL ISBN NO PUEDE ESTAR VACIO")
    private String isbn;

    @NotBlank(message = "Necesita un titulo")
    private String titulo;

    @NotBlank(message = "Necesita una editorial")
    private String editorial;

    @NotNull(message = "Necesita una fecha de publicacion")
    @Min(value = 1000, message = "El año debe ser mayor a 1000")
    @Max(value = 2026, message = "El año debe ser menor o igual a 2026")
    private Integer fechaPublicacion;

    @NotBlank(message = "Necesita un autor")
    private String autor;
}
//http://localhost:8081/api/v1/libros postman url dont forget