package com.holamundo.ejemplo.holamundo.controller;

import com.holamundo.ejemplo.holamundo.model.Libro;
import com.holamundo.ejemplo.holamundo.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroServicio;

    @GetMapping
    public List<Libro> listarLibro() {
        return libroServicio.getLibros();
    }

    @PostMapping
    public ResponseEntity<?> agregarLibro(@RequestBody @Valid Libro libro, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        try {
            Libro nuevo = libroServicio.saveLibro(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error al agregar el libro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id) { // Nombre original: buscarLibro
        return libroServicio.getLibroId(id);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) { // Nombre original: actualizarLibro
        return libroServicio.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id) { // Nombre original: eliminarLibro
        return libroServicio.deleteLibro(id);
    }

    // --- Nuevos Endpoints manteniendo el estilo de nombres ---

    @DeleteMapping("/eliminart/{titulo}")
    public String eliminarLibroPorTitulo(@PathVariable String titulo) {
        return libroServicio.eliminart(titulo);
    }

    @GetMapping("/total")
    public int totalLibros() {
        return libroServicio.totalLibros();
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarPorIsbn(@PathVariable String isbn) {
        return libroServicio.getLibroIsbn(isbn);
    }

    @GetMapping("/fechaPublicacion/{fechaPublicacion}")
    public Libro buscarPorFechaPublicacion(@PathVariable int fechaPublicacion) {
        return libroServicio.getLibroFechaPublicacion(fechaPublicacion);
    }

    @GetMapping("/titulo/{titulo}")
    public Libro buscarPorTitulo(@PathVariable String titulo) {
        return libroServicio.getLibroTitulo(titulo);
    }

    @GetMapping("/autor/{autor}")
    public Libro buscarPorAutor(@PathVariable String autor) {
        return libroServicio.getLibroAutor(autor);
    }

    @GetMapping("/masAntiguo")
    public Libro obtenerMasAntiguo() {
        return libroServicio.obtenerMasAntiguo();
    }

    @GetMapping("/masNuevo")
    public Libro obtenerMasNuevo() {
        return libroServicio.obtenerMasNuevo();
    }

    @GetMapping("/ordenados")
    public List<Libro> listarLibrosOrdenados() {
        return libroServicio.listarLibrosOrdenados();
    }
}